import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static String[] dots;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dots = new String[n];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++)
            dots[i] = br.readLine();

        boolean isCycle = false;
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j])
                    continue;

                isCycle = dfs(i, j, -1, -1);
                if (isCycle)
                    break loop;
            }
        }

        bw.write((isCycle ? "Yes" : "No"));
        bw.flush();
    }

    private static boolean dfs(int y, int x, int py, int px) {
        if (visit[y][x])
            return true;

        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                continue;
            if (ny == py && nx == px)
                continue;

            if (dots[y].charAt(x) == dots[ny].charAt(nx)) {
                if (dfs(ny, nx, y, x))
                    return true;
            }
        }

        return false;
    }

}
