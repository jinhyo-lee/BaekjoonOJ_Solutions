import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long mod = 1000000000;
        long[][] dp = new long[n + 1][10];

        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][1] % mod;
                else if (j == 9)
                    dp[i][j] = dp[i - 1][8] % mod;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long res = 0;
        for (int i = 0; i < 10; i++)
            res += dp[n][i];

        bw.write(res % mod + "\n");
        bw.flush();
    }

}
