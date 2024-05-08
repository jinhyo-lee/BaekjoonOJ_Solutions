import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] mat = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) mat[i][j] = s.charAt(j) == 'x';
        }

        bw.write(bfs(mat));
        bw.flush();
    }

    private static String bfs(boolean[][] mat) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        mat[0][0] = true;

        int[][] dir = {{1, 0}, {0, 1}};
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == mat.length - 1 && cur.x == mat.length - 1) return "Yes";

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= mat.length || nx < 0 || nx >= mat.length || mat[ny][nx]) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = true;
            }
        }

        return "No";
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
