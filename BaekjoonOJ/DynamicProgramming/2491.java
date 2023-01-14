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

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = dp[0][2] = 1;

        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());

            if (dp[i][0] >= dp[i - 1][0])
                dp[i][1] = dp[i - 1][1] + 1;
            else
                dp[i][1] = 1;

            if (dp[i][0] <= dp[i - 1][0])
                dp[i][2] = dp[i - 1][2] + 1;
            else
                dp[i][2] = 1;

            max = Math.max(max, Math.max(dp[i][1], dp[i][2]));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
