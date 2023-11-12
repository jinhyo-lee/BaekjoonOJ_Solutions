import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(bfs(new Pair(read() - 1, read() - 1), new Pair(read() - 1, read() - 1))));
        bw.flush();
    }

    private static int bfs(Pair src, Pair tgt) {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] mat = new int[8][8], dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        q.offer(src);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == tgt.y && cur.x == tgt.x) return mat[tgt.y][tgt.x];

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || mat[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = mat[cur.y][cur.x] + 1;
            }
        }

        return -1;
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
