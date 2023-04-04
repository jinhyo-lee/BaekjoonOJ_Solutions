import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);

            int[] dp = new int[n + 1];
            int max = -10000;
            for (int i = 1; i <= n; i++) {
                int p = Integer.parseInt(br.readLine());
                dp[i] = Math.max(p, dp[i - 1] + p);

                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
