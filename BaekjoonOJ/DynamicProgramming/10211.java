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
            int[] dp = new int[n];

            st = new StringTokenizer(br.readLine());
            int max = dp[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < n; i++) {
                dp[i] = Integer.parseInt(st.nextToken());
                dp[i - 1] = dp[i - 1] < 0 ? 0 : dp[i - 1];

                dp[i] = dp[i - 1] + dp[i];
                max = Math.max(max, dp[i]);
            }

            bw.write(max + "\n");
        }

        bw.flush();
    }

}
