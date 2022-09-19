import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m, h;
    static boolean[][] map;
    static boolean finish;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new boolean[h + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = true;
        }

        for (int i = 0; i <= 3; i++) {
            min = i;
            recur(1, 0);

            if (finish)
                break;
        }

        bw.write((finish ? min : -1) + "\n");
        bw.flush();
    }

    private static void recur(int idx, int cnt) {
        if (finish)
            return;

        if (min == cnt) {
            if (isPass())
                finish = true;

            return;
        }

        for (int i = idx; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (!map[i][j]) {
                    map[i][j] = true;
                    recur(i, cnt + 1);
                    map[i][j] = false;
                }
            }
        }
    }

    private static boolean isPass() {
        for (int i = 1; i <= n; i++) {
            int y = 1;
            int x = i;

            for (int j = 0; j < h; j++) {
                if (map[y][x])
                    x++;
                else if (map[y][x - 1])
                    x--;

                y++;
            }

            if (x != i)
                return false;
        }

        return true;
    }

}
