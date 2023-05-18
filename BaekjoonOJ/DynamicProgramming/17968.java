import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 2];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int j = 1;
            do dp[i] = j++; while (!isMinimum(i));
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }

    private static boolean isMinimum(int i) {
        for (int k = 1; i - 2 * k >= 0; k++)
            if (dp[i] == 2 * dp[i - k] - dp[i - 2 * k]) return false;

        return true;
    }

}
