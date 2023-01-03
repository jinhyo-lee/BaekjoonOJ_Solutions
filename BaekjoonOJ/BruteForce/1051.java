import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        int len = Math.min(n, m);

        loop:
        while (len > 1) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= m - len; j++) {
                    int v = map[i][j];
                    if (v == map[i + len - 1][j] && v == map[i][j + len - 1] && v == map[i + len - 1][j + len - 1])
                        break loop;
                }
            }
            len--;
        }

        bw.write(String.valueOf(len * len));
        bw.flush();
    }

}
