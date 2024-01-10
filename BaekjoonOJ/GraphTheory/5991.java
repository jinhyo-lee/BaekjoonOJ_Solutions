import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int r, c, cnt;
    static int[][] mat, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mat = new int[r = read()][c = read()];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) mat[i][j] = read();

        dfs(0, 0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int y, int x) {
        cnt += mat[y][x];
        mat[y][x] = -1;

        if (y == r - 1 && x == c - 1) return;

        int ny = 0, nx = 0;
        for (int[] d : dir) {
            int ty = y + d[0], tx = x + d[1];
            if (ty < 0 || ty >= r || tx < 0 || tx >= c || mat[ty][tx] == -1) continue;

            if (mat[ny][nx] < mat[ty][tx]) {
                ny = ty;
                nx = tx;
            }
        }

        dfs(ny, nx);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
