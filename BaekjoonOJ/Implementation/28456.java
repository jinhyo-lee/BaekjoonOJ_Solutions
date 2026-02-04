import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[][] mat = new int[n][n], tmp = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) mat[i][j] = read();

        int q = read();
        while (q-- > 0) {
            if (read() == 1) {
                int i = read() - 1, v = mat[i][n - 1];
                System.arraycopy(mat[i], 0, mat[i], 1, n - 1);
                mat[i][0] = v;
            } else {
                for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) tmp[j][n - 1 - i] = mat[i][j];
                int[][] swp = mat;
                mat = tmp;
                tmp = swp;
            }
        }

        for (int i = 0; i < n; i++, sb.append('\n')) for (int j = 0; j < n; j++) sb.append(mat[i][j]).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
