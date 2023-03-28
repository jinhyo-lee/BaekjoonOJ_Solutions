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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[r + w + 1][r + w + 1];

        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }

        int sum = 0;
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j < i; j++)
                sum += dp[r + i][c + j];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
