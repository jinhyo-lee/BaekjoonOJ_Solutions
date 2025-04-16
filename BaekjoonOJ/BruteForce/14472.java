import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
        mat = new boolean[n][m];
        for (int i = 0, j = 0; i < n; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c == '#';

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j]) continue;
                if (i + d <= n && traverse(i, j, d, 1, 0)) cnt++;
                if (j + d <= m && traverse(i, j, d, 0, 1)) cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean traverse(int i, int j, int d, int y, int x) {
        while (d-- > 1) if (mat[i += y][j += x]) return false;
        return true;
    }

}
