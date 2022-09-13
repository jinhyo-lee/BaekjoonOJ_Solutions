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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int maxSum = 0;
        for (int bit = 0; bit < (1 << n * m); bit++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                int tmp = 0;
                for (int j = 0; j < m; j++) {
                    int cur = i * m + j;

                    if ((bit & (1 << cur)) == 0)
                        tmp = tmp * 10 + map[i][j];
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }

                sum += tmp;
            }

            for (int j = 0; j < m; j++) {
                int tmp = 0;
                for (int i = 0; i < n; i++) {
                    int cur = i * m + j;

                    if ((bit & (1 << cur)) != 0)
                        tmp = tmp * 10 + map[i][j];
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }

                sum += tmp;
            }

            maxSum = Math.max(maxSum, sum);
        }

        bw.write(maxSum + "\n");
        bw.flush();
    }

}
