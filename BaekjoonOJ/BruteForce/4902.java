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

        int tc = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0)
                break;

            int[][] tri = new int[n + 1][2 * n];
            int[][] pSum = new int[n + 1][2 * n];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < 2 * i; j++) {
                    tri[i][j] = Integer.parseInt(st.nextToken());
                    pSum[i][j] = tri[i][j] + pSum[i][j - 1];
                }
            }

            int max = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < 2 * i; j += 2) {
                    int sum = 0;
                    for (int k = 0; k <= n - i; k++) {
                        sum += pSum[i + k][j + 2 * k] - pSum[i + k][j - 1];
                        max = Math.max(max, sum);
                    }
                }
            }

            for (int i = n; i >= 1; i--) {
                for (int j = 2; j < 2 * i; j += 2) {
                    int sum = 0;
                    for (int k = 0; k < Math.min(j / 2, i - j / 2); k++) {
                        sum += pSum[i - k][j] - pSum[i - k][j - 2 * k - 1];
                        max = Math.max(max, sum);
                    }
                }
            }

            bw.write(tc++ + ". " + max + "\n");
        }

        bw.flush();
    }

}
