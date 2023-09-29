import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine(), b = br.readLine();

        int[] dp = new int[17];
        for (int i = 0; i < 8; i++) {
            dp[i * 2] = a.charAt(i) - '0';
            dp[i * 2 + 1] = b.charAt(i) - '0';
        }

        bw.write(recur(dp, dp.length - 1));
        bw.flush();
    }

    private static String recur(int[] dp, int len) {
        if (len == 2) return String.valueOf(dp[0]) + dp[1];

        for (int i = 0; i < len; i++) dp[i] = (dp[i] + dp[i + 1]) % 10;

        return recur(dp, len - 1);
    }

}
