import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static char[][] mat;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            mat = new char[h][w];
            for (int i = 0; i < h; i++) mat[i] = br.readLine().toCharArray();

            for (int i = 0; i < h; i++)
                for (int j = 0; j < w; j++) if (mat[i][j] == 'S') bfs(i, j);

            for (int i = 0; i < h; i++, sb.append("\n"))
                for (int j = 0; j < w; j++) sb.append(mat[i][j]);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        mat[y][x] = 'S';

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

                if (mat[ny][nx] == 'T') {
                    q.offer(new Pair(ny, nx));
                    mat[ny][nx] = 'S';
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
