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

        String s;
        Pair src = new Pair((s = br.readLine()).charAt(0) - 'a', s.charAt(1) - '1');
        Pair tgt = new Pair((s = br.readLine()).charAt(0) - 'a', s.charAt(1) - '1');

        Queue<Pair> q = new ArrayDeque<>();
        int[][] mat = new int[8][8], dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        q.offer(src);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == tgt.y && cur.x == tgt.x) break;

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8 || mat[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = mat[cur.y][cur.x] + 1;
            }
        }

        bw.write(String.valueOf(mat[tgt.y][tgt.x]));
        bw.flush();
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
