import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = read(), n = read(), m = Math.abs(n - h);

        long[][] dp = new long[m + 1][m + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= m; i++)
            for (int j = i; j <= m; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        bw.write(String.valueOf(dp[m][m]));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
