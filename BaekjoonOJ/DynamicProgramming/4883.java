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

        StringBuilder sb = new StringBuilder();
        int tc = 1;

        String input;
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);

            int[][] dp = new int[n][3];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++)
                    dp[i][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = 1001;
            dp[0][2] += dp[0][1];

            for (int i = 1; i < n; i++) {
                dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] += Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])));
                dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
            }

            sb.append(tc++).append(". ").append(dp[n - 1][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
