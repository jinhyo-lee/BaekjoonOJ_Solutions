import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int row = a.length();
        int col = b.length();
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        bw.write(String.valueOf(dp[row][col]));
        bw.flush();
    }

}
