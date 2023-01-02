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
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;
        int height = Math.min((sum + b) / (n * m), 256) + 1;

        while (height-- > 0) {
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > height)
                        time += (map[i][j] - height) * 2;
                    else
                        time += height - map[i][j];
                }
            }

            if (minTime > time) {
                minTime = time;
                maxHeight = height;
            }
        }

        bw.write(minTime + " " + maxHeight);
        bw.flush();
    }

}
