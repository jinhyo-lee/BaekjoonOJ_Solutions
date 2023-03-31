import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        int[] p = new int[t + 1];
        BigInteger[] q = new BigInteger[t + 1];

        int max = 0;
        for (int i = 1; i <= t; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            q[i] = new BigInteger(st.nextToken());
            max = Math.max(max, p[i]);
        }

        BigInteger[] dp = new BigInteger[max + 1];

        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= max; i++)
            dp[i] = dp[i - 1].add(dp[i - 2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++)
            sb.append("Case #").append(i).append(": ").append(dp[p[i]].remainder(q[i])).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
