import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read();
        while (t-- > 0) {
            int m = read(), n = read();
            boolean[][] mat = new boolean[m][n];
            for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) mat[i][j] = read() == 1;

            int cnt = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++) if (mat[j][i]) for (int k = j + 1; k < m; k++) if (!mat[k][i]) cnt++;
            bw.write(cnt + "\n");
        }

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
