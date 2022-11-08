import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[101];

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for (int i = 6; i <= 100; i++)
            dp[i] = dp[i - 1] + dp[i - 5];

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0)
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");

        bw.flush();
    }

}
