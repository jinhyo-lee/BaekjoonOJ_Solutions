import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int r, c, cnt;
    static int[][] mat, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mat = new int[r = read()][c = read()];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) mat[i][j] = read();
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) if (mat[i][j] > 0) bfs(new Pair(i, j));

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(Pair src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(src);
        mat[src.y][src.x] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c || mat[ny][nx] == 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = 0;
            }
        }

        cnt++;
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
