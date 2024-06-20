import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static boolean[][] mat;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int z = Integer.parseInt(br.readLine());
        while (z-- > 0) {
            int n = Integer.parseInt(br.readLine());
            mat = new boolean[n + 2][n + 2];
            for (int i = 1; i <= n; i++) {
                String s = br.readLine();
                for (int j = 1; j <= n; j++) mat[i][j] = s.charAt(j - 1) == '#';
            }

            sb.append(bfs(new Pair(0, 0))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(Pair src) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(src);
        mat[src.y][src.x] = true;

        int cnt = mat.length * mat.length;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            cnt--;
            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= mat.length || nx < 0 || nx >= mat.length || mat[ny][nx]) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = true;
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
