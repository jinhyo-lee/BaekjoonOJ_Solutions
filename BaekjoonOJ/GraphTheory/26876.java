import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        Pair src = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine(), ":");

        bw.write(String.valueOf(bfs(src, new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))));
        bw.flush();
    }

    private static int bfs(Pair src, Pair tgt) {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] mat = new int[24][60], dir = {{0, 1}, {1, 0}};

        q.offer(src);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == tgt.y && cur.x == tgt.x) return mat[tgt.y][tgt.x];

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];

                if (nx > 59) {
                    nx = 0;
                    ny++;
                }
                if (ny > 23) ny = 0;
                if (mat[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = mat[cur.y][cur.x] + 1;
            }
        }

        return -1;
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
