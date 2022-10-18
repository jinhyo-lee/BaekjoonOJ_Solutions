import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }

        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == -1)
                continue;
            for (int j = 0; j <= arr[i]; j++) {
                if (i + j >= n)
                    continue;
                if (dp[i + j] == -1 || dp[i + j] > dp[i] + 1)
                    dp[i + j] = dp[i] + 1;
            }
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
    }

}
