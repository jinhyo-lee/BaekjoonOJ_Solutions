import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][][] map = new int[21][21][5];
    static int[] dy = {1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++)
                map[i][j][4] = Integer.parseInt(st.nextToken());
        }

        bw.write(search());
        bw.flush();
    }

    private static String search() {
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (map[i][j][4] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (map[i][j][k] == 0 && check(i, j, k, map[i][j][4]) == 5)
                        return map[i][j][4] + "\n" + i + " " + j;
                }
            }
        }

        return "0";
    }

    private static int check(int y, int x, int dir, int color) {
        y += dy[dir];
        x += dx[dir];

        if (map[y][x][4] == color)
            return map[y][x][dir] = check(y, x, dir, color) + 1;

        return 1;
    }

}
