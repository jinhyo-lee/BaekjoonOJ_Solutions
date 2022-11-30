import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][41];
            dp[0][0] = dp[1][1] = 1;
            dp[0][1] = dp[1][0] = 0;

            for (int i = 2; i <= n; i++) {
                dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
                dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
            }

            bw.write(dp[0][n] + " " + dp[1][n] + "\n");
        }

        bw.flush();
    }

}
