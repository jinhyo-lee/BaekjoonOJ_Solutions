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
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            wine[i] = Integer.parseInt(br.readLine());

        dp[1] = wine[1];

        if (n > 1)
            dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i], dp[i - 1]);

        bw.write(dp[n] + "\n");
        bw.flush();
    }

}
