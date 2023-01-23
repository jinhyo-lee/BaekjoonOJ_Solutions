import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static boolean flag;
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (flag)
                break;
            if (map[0][i] == '0')
                dfs(0, i);
        }

        bw.write(flag ? "YES" : "NO");
        bw.flush();
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        if (y == m - 1) {
            flag = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= m || nx < 0 || nx >= n)
                continue;

            if (map[ny][nx] == '0' && !visit[ny][nx])
                dfs(ny, nx);
        }
    }

}
