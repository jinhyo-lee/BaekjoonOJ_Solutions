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
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            Set<String> set = new HashSet<>();
            while (n-- > 0) {
                char[] arr = br.readLine().toCharArray();

                Arrays.sort(arr);

                StringBuilder group = new StringBuilder();
                char prev = ' ';
                for (char c : arr)
                    if (c != prev) group.append(prev = c);

                set.add(group.toString());
            }

            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
