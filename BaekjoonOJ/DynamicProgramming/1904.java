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

        bw.write(String.valueOf(tiling(n)));
        bw.flush();
    }

    private static long tiling(int n) {
        if (n == 1)
            return 1;

        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;

        return dp[n];
    }

}
