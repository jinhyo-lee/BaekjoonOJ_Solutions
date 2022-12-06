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

        int[] dp = new int[n + 1];

        final int inf = Integer.MAX_VALUE;
        int min;
        for (int i = 1; i <= n; i++) {
            min = inf;
            for (int j = 1; j * j <= i; j++)
                min = Math.min(min, dp[i - j * j]);

            dp[i] = min + 1;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }

}
