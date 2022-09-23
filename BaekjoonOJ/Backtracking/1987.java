import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int r, c, max;
    static char[][] map;
    static boolean[] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[26];

        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        recur(0, 0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int y, int x, int cnt) {
        int idx = map[y][x] - 'A';

        if (visit[idx]) {
            max = Math.max(max, cnt);
            return;
        }

        visit[idx] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < r && nx < c)
                recur(ny, nx, cnt + 1);
        }
        visit[idx] = false;
    }

}
