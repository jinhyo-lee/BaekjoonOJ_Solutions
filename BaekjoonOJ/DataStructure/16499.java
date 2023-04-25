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

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);

            set.add(String.valueOf(input));
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

}
