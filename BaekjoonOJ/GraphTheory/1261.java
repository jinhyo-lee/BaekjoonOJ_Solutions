import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] dist;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijkstra();

        bw.write(String.valueOf(dist[n - 1][m - 1]));
        bw.flush();
    }

    private static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);

        pq.offer(new Edge(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cnt > dist[now.y][now.x])
                continue;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;

                if (dist[ny][nx] > dist[now.y][now.x] + map[ny][nx] - '0') {
                    dist[ny][nx] = dist[now.y][now.x] + map[ny][nx] - '0';
                    pq.offer(new Edge(ny, nx, dist[ny][nx]));
                }
            }
        }
    }

    private static class Edge {
        int y, x, cnt;

        public Edge(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

}
