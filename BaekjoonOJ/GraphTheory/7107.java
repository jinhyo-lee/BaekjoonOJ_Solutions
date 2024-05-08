import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(bfs(read(), read(), read() - 1, read() - 1));
        bw.flush();
    }

    private static String bfs(int n, int m, int y, int x) {
        int[][] mat = new int[n][m], dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == y && cur.x == x) return String.valueOf(mat[y][x]);

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || mat[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = mat[cur.y][cur.x] + 1;
            }
        }

        return "NEVAR";
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
