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

        BigInteger[] dp = new BigInteger[500];
        dp[0] = dp[1] = BigInteger.ONE;

        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1].add(dp[i - 2]);

        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);

            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            int cnt = 0;
            for (int i = 1; i < dp.length; i++) {
                if (b.compareTo(dp[i]) < 0)
                    break;
                if (a.compareTo(dp[i]) < 1)
                    cnt++;
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
