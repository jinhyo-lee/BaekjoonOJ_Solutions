import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    String pair = arr[i] + " " + arr[j];

                    if (!set.contains(pair)) {
                        set.add(pair);
                        sb.append(pair).append("\n");
                    }
                }
            }
        }

        bw.write(sb.append(set.size()).toString());
        bw.flush();
    }

}
