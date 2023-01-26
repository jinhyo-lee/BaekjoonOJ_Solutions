import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    map[i][j] = 1;
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y, x));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n || map[ny][nx] == 0)
                    continue;
                map[ny][nx] = 0;
                q.offer(new Pair(ny, nx));
            }
        }
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
