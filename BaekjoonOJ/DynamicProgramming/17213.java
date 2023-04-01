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
        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++)
            dp[i][i] = 1;

        for (int i = 1; i <= m; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= m; j++)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
        }

        bw.write(String.valueOf(dp[n][m]));
        bw.flush();
    }

}
