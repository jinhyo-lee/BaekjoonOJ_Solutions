import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n, m;
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        m = read();
        mat = new boolean[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) mat[i][j] = read() == 1;

        bw.write(bfs() ? "Yes" : "No");
        bw.flush();
    }

    private static boolean bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        mat[0][0] = true;

        n--;
        m--;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == m && cur.x == n) return true;

            int ny = cur.y + 1, nx = cur.x + 1;
            if (ny <= m && mat[ny][cur.x]) {
                q.offer(new Pair(ny, cur.x));
                mat[ny][cur.x] = false;
            }

            if (nx <= n && mat[cur.y][nx]) {
                q.offer(new Pair(cur.y, nx));
                mat[cur.y][nx] = false;
            }
        }

        return false;
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
