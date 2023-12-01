import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read(), k = read();
        mat = new int[n][m];

        fill(0, 0, 1);
        if (k != 0) {
            int y = (k - 1) / m, x = (k - 1) % m;
            memoization(1, 1, y + 1, x + 1);

            fill(y, x, mat[y][x]);
            memoization(y + 1, x + 1, n, m);
        } else memoization(1, 1, n, m);

        bw.write(String.valueOf(mat[n - 1][m - 1]));
        bw.flush();
    }

    private static void fill(int y, int x, int val) {
        for (int i = x; i < mat[0].length; i++) mat[y][i] = val;
        for (int i = y; i < mat.length; i++) mat[i][x] = val;
    }

    private static void memoization(int sy, int sx, int dy, int dx) {
        for (int i = sy; i < dy; i++) for (int j = sx; j < dx; j++) mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
