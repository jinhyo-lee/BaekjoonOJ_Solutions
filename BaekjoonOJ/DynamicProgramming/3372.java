import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[][] mat = new int[n][n];
        BigInteger[][] cnt = new BigInteger[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = read();
                cnt[i][j] = BigInteger.ZERO;
            }
        }

        cnt[0][0] = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;

                int k = mat[i][j];
                if (i + k < n) cnt[i + k][j] = cnt[i + k][j].add(cnt[i][j]);
                if (j + k < n) cnt[i][j + k] = cnt[i][j + k].add(cnt[i][j]);
            }
        }

        bw.write(String.valueOf(cnt[n - 1][n - 1]));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
