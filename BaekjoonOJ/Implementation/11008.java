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
            String s = br.readLine(), p = s.substring(s.indexOf(' ') + 1);
            s = s.substring(0, s.indexOf(' '));

            int n = s.length(), m = p.length(), c = p.charAt(0), sec = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != c || i + m > n) continue;
                int cnt = 0, k = i;
                for (int j = 0; j < m; j++) if (s.charAt(k++) == p.charAt(j)) cnt++;

                if (cnt == m) {
                    i = k - 1;
                    sec++;
                }
            }
            sb.append(n - sec * (m - 1)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
