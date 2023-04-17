import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i][j] = (r + g + b) / 3;
            }
        }

        t = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || arr[i][j] < t)
                    continue;

                bfs(i, j);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (visit[ny][nx] || arr[ny][nx] < t)
                    continue;

                visit[ny][nx] = true;
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
