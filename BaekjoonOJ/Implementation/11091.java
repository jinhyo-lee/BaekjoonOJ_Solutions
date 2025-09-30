import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int[] arr = new int[26];
            for (char c : br.readLine().toLowerCase().toCharArray()) {
                int i = c - 'a';
                if (i >= 0 && i < 26) arr[i]++;
            }

            StringBuilder sb = new StringBuilder("missing ");
            for (int i = 0; i < 26; i++) if (arr[i] == 0) sb.append((char) (i + 'a'));

            bw.write(sb.length() == 8 ? "pangram\n" : sb.append('\n').toString());
        }

        bw.flush();
    }

}
