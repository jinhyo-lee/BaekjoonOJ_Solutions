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

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];

            dp[0] = 1;
            for (int c : arr) {
                for (int i = c; i <= m; i++)
                    dp[i] += dp[i - c];
            }

            bw.write(dp[m] + "\n");
        }

        bw.flush();
    }

}
