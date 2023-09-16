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
    static char[][] mat;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            mat = new char[r][c];
            Pair s = null;

            for (int i = 0; i < r; i++) {
                String input = br.readLine();
                for (int j = 0; j < c; j++) {
                    mat[i][j] = input.charAt(j);
                    if (mat[i][j] == 'S') s = new Pair(i, j, 0);
                }
            }

            int cnt = bfs(s);

            if (cnt != 0) sb.append("Shortest Path: ").append(cnt);
            else sb.append("No Exit");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(Pair s) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(s);
        mat[s.y][s.x] = ' ';

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

                if (mat[ny][nx] == 'G') return cur.cnt + 1;

                if (mat[ny][nx] == 'O' || mat[ny][nx] == '0') {
                    q.offer(new Pair(ny, nx, cur.cnt + 1));
                    mat[ny][nx] = ' ';
                }
            }
        }

        return 0;
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
