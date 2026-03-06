import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), t = read(), y = 0, x = 0, d = 0, cur = 0;
        int[][] mat = new int[n][2], dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int i = 0; i < n; i++) {
            mat[i][0] = read();
            mat[i][1] = read() == 29784 ? 0 : 1;
        }

        for (int i = 0; i < n; cur = mat[i++][0]) {
            int gap = mat[i][0] - cur;
            y += dir[d][0] * gap;
            x += dir[d][1] * gap;
            d = ((mat[i][1] == 0 ? ++d : --d) + 4) % 4;
        }

        bw.write((x + dir[d][1] * (t - cur)) + " " + (y + dir[d][0] * (t - cur)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
