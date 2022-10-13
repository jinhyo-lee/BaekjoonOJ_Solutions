import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static char[][] map;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        for (int t = 0; t < 2; t++) {
            visit = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        dfs(i, j, map[i][j]);
                        cnt++;
                    }
                    if (map[i][j] == 'G')
                        map[i][j] = 'R';
                }
            }

            bw.write(cnt + " ");
        }

        bw.flush();
    }

    private static void dfs(int y, int x, char color) {
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                continue;
            if (visit[ny][nx] || map[ny][nx] != color)
                continue;

            dfs(ny, nx, color);
        }
    }

}
