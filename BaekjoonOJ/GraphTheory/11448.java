import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n, cnt;
    static char[][] mat;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine().trim());
            cnt = 0;
            mat = new char[n][n];

            for (int i = 0; i < n; i++) mat[i] = br.readLine().trim().toCharArray();
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (mat[i][j] == 'w') bfs(new Pair(i, j));

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(Pair src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(src);

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || mat[ny][nx] != '-') continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = 'w';
                cnt++;
            }
        }
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
