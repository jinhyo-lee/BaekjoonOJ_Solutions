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

        boolean[][] map = new boolean[n + 1][n + 1];
        int[] cnt = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = true;
            map[x][y] = true;

            cnt[y]++;
            cnt[x]++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!map[i][j])
                    continue;

                for (int k = j + 1; k <= n; k++) {
                    if (!map[i][k] || !map[j][k])
                        continue;

                    min = Math.min(min, cnt[i] + cnt[j] + cnt[k] - 6);
                }
            }
        }

        bw.write((min == Integer.MAX_VALUE ? -1 : min) + "\n");
        bw.flush();
    }

}
