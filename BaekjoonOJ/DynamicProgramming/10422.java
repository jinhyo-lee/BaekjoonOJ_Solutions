import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[2501];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j <= i - 1; j++)
                dp[i] = (dp[i] + dp[j] * dp[i - 1 - j]) % 1000000007L;
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());
            bw.write((l % 2 == 0 ? dp[l / 2] : 0) + "\n");
        }

        bw.flush();
    }

}
