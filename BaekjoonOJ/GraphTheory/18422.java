import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] mat;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mat = new char[n][m];
        for (int i = 0; i < n; i++) mat[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '*') {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int y, int x) {
        for (int[] d : dir) {
            int ny = y + d[0], nx = x + d[1];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || mat[ny][nx] == '.') continue;

            mat[ny][nx] = '.';
            dfs(ny, nx);
        }
    }

}
