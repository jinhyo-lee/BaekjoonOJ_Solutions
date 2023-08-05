import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n, m, k;
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        m = read();
        k = read();

        if (m > 0) bw.write(isPossible());
        else bw.write("IMPOSSIBLE");

        bw.flush();
    }

    private static String isPossible() throws IOException {
        arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) arr[i][j] = read();

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) if (arr[i][j] == 0) cnt += bfs(i, j);

        return cnt > m || cnt == 0 ? "IMPOSSIBLE" : "POSSIBLE\n" + (m - cnt);
    }

    private static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        arr[y][x] = -1;

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                arr[ny][nx] = -1;
            }
        }

        return cnt % k != 0 ? cnt / k + 1 : cnt / k;
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
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
