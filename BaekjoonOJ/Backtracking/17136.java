import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[10][10];

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0, 0);

        bw.write(min == Integer.MAX_VALUE ? "-1" : String.valueOf(min));
        bw.flush();
    }

    private static void recur(int y, int x, int cnt) {
        if (y == 10) {
            min = Math.min(min, cnt);
            return;
        }

        if (x == 10) {
            recur(y + 1, 0, cnt);
            return;
        }

        if (map[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paper[i] > 0 && canAttach(y, x, i)) {
                    paper[i]--;
                    convert(y, x, i, 0);
                    recur(y, x + 1, cnt + 1);
                    convert(y, x, i, 1);
                    paper[i]++;
                }
            }
        } else
            recur(y, x + 1, cnt);
    }

    private static boolean canAttach(int y, int x, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (y + i > 9 || x + j > 9 || map[y + i][x + j] == 0)
                    return false;
            }
        }

        return true;
    }

    private static void convert(int y, int x, int size, int state) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                map[y + i][x + j] = state;
        }
    }

}
