import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n, m;
    static int[][] dist;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = read();
        m = read();

        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') {
                    q.offer(new Pair(i, j));
                    dist[i][j] = 0;
                } else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        for (int[] arr : dist) {
            for (int i : arr) sb.append(i).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int nd = dist[cur.y][cur.x] + 1;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if (dist[ny][nx] > nd) {
                    q.offer(new Pair(ny, nx));
                    dist[ny][nx] = nd;
                }
            }
        }
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
