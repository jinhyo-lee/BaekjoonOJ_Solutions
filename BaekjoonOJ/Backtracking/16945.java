import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[3][3];
        visit = new boolean[10];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 0);

        bw.write(min + "\n");
        bw.flush();
    }

    private static void recur(int y, int x, int sum) {
        if (x == 3) {
            recur(y + 1, 0, sum);
            return;
        }

        if (y == 3) {
            int diag = map[0][0] + map[2][2];

            if (diag == map[2][0] + map[0][2]) {
                if (isEqual(diag + map[1][1]))
                    min = Math.min(min, sum);
            }
            return;
        }

        int tmp = map[y][x];
        for (int i = 1; i <= 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                map[y][x] = i;
                recur(y, x + 1, sum + Math.abs(tmp - i));
                visit[i] = false;
                map[y][x] = tmp;
            }
        }
    }

    private static boolean isEqual(int diag) {
        for (int i = 0; i < 3; i++) {
            int vert = 0;
            int horiz = 0;
            for (int j = 0; j < 3; j++) {
                vert += map[i][j];
                horiz += map[j][i];
            }

            if (vert != diag || horiz != diag)
                return false;
        }

        return true;
    }

}
