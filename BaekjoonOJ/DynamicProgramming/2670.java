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

        double[] dp = new double[n];
        double max = 0;

        dp[0] = Double.parseDouble(br.readLine());
        for (int i = 1; i < n; i++) {
            dp[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(dp[i], dp[i - 1] * dp[i]);
            max = Math.max(max, dp[i]);
        }

        bw.write(String.format("%.3f", max));
        bw.flush();
    }

}
