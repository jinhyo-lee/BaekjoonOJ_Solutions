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
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++)
            dp[0][i] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++)
                    dp[i][j] += (dp[i - 1][k]) % 10007;
            }
        }

        bw.write(dp[n][0] % 10007 + "\n");
        bw.flush();
    }

}
