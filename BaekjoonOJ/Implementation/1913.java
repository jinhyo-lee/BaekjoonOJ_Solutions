import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read(), k = n * n, y = 0, x = 0, d = 0;
        String s = "1 1";
        int[][] mat = new int[n][n], dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        mat[0][0] = k--;
        while (k > 0) {
            int ny = y + dir[d][0], nx = x + dir[d][1];
            if (ny < 0 || ny == n || nx < 0 || nx == n || mat[ny][nx] > 0) d = ++d % 4;
            else {
                if (k == m) s = (ny + 1) + " " + (nx + 1);
                mat[y = ny][x = nx] = k--;
            }
        }

        for (int i = 0; i < n; i++, sb.append("\n")) for (int j = 0; j < n; j++) sb.append(mat[i][j]).append(" ");

        bw.write(sb.append(s).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
