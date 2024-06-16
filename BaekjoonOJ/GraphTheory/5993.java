import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1, y = r - Integer.parseInt(st.nextToken());
        Pair src = new Pair(y, x, 0);

        mat = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) mat[i][j] = s.charAt(j) == '*';
        }

        bw.write(String.valueOf(bfs(src)));
        bw.flush();
    }

    private static int bfs(Pair src) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(src);
        mat[src.y][src.x] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            cnt = cur.cnt;
            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= r || nx < 0 || nx >= c || mat[ny][nx]) continue;

                q.offer(new Pair(ny, nx, cur.cnt + 1));
                mat[ny][nx] = true;
            }
        }

        return cnt;
    }

    private static class Pair {
        int y, x, cnt;

        Pair(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

}
