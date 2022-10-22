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
        long[] dp = new long[n + 1];

        for (int i = 1; i <= Math.min(n, 6); i++)
            dp[i] = i;

        for (int i = 7; i <= n; i++) {
            for (int j = 2; j <= 4; j++)
                dp[i] = Math.max(dp[i], dp[i - (j + 1)] * j);
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }

}
