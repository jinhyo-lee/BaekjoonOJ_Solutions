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

        int[] arr = new int[n];
        long[][] dp = new long[n][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0][arr[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j + arr[i] <= 20)
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }

        bw.write(String.valueOf(dp[n - 2][arr[n - 1]]));
        bw.flush();
    }

}
