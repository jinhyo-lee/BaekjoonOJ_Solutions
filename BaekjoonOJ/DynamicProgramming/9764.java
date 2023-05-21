import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[Integer.parseInt(br.readLine())];
        int max = 0;

        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i] = Integer.parseInt(br.readLine()));

        int[] dp = new int[max + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = max; j >= i; j--)
                dp[j] = (dp[j] + dp[j - i]) % 100999;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : arr)
            sb.append(dp[n]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
