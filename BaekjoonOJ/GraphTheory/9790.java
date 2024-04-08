import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            mat = new boolean[h][w];

            int y = 0, x = 0;
            for (int i = 0; i < h; i++) {
                s = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    if (c != '#') {
                        if (c == 'A') {
                            y = i;
                            x = j;
                        }
                        mat[i][j] = true;
                    }
                }
            }

            sb.append(bfs(new Pair(y, x))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(Pair root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(root);
        mat[root.y][root.x] = false;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cnt = 1;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= h || nx < 0 || nx >= w || !mat[ny][nx]) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = false;
                cnt++;
            }
        }
        return cnt;
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
