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

        int[][] dp = new int[30][30];

        for (int i = 1; i < 30; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
            for (int j = 2; j < 30; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(dp[m][n] + "\n");
        }

        bw.flush();
    }

}
