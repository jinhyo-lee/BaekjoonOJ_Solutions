import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '#') {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c)
                    continue;

                if (map[ny][nx] == '#') {
                    map[ny][nx] = '.';
                    q.offer(new Pair(ny, nx));
                }
            }
        }
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
