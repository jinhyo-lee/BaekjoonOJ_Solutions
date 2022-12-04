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

        boolean[] dp = new boolean[n + 1];

        if (n > 1)
            dp[2] = true;

        for (int i = 4; i <= n; i++)
            dp[i] = !dp[i - 1];

        bw.write(dp[n] ? "CY" : "SK");
        bw.flush();
    }

}
