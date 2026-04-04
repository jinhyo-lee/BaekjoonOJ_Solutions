import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int[] arr = new int[26];
            for (char c : br.readLine().toCharArray()) if (c != ' ') arr[c - 'a']++;

            char c = ' ';
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (max > arr[i]) continue;
                c = max == arr[i] ? '?' : (char) (i + 'a');
                max = arr[i];
            }
            sb.append(c).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
