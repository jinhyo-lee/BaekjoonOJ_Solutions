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

        if (n > 0)
            bw.write("1\n");
        else if (n < 0) {
            n = -n;
            if (n % 2 == 0)
                bw.write("-1\n");
            else
                bw.write("1\n");
        } else
            bw.write("0\n");

        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1;

        final int mod = 1000000000;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }

}
