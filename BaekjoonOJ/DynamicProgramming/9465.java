import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++)
                    dp[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i <= n; i++) {
                dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
            }

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        bw.flush();
    }

}
