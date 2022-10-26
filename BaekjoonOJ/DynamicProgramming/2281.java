import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] name, dp;
    static final int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        name = new int[1000];
        dp = new int[1000];
        Arrays.fill(dp, inf);

        for (int i = 0; i < n; i++)
            name[i] = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(recur(0)));
        bw.flush();
    }

    private static int recur(int idx) {
        if (dp[idx] < inf)
            return dp[idx];

        int remain = m - name[idx];

        for (int i = idx + 1; i <= n && remain >= 0; i++) {
            if (i == n) {
                dp[idx] = 0;
                break;
            }
            dp[idx] = Math.min(dp[idx], remain * remain + recur(i));
            remain -= name[i] + 1;
        }

        return dp[idx];
    }

}
