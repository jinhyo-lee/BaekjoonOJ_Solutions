import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static int[][] mat;
    static Pair src, tgt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        mat = new int[y][x];
        for (int i = 0; i < y; i++) {
            String s = br.readLine();
            for (int j = 0; j < x; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '*':
                        mat[i][j] = -1;
                        break;
                    case 'K':
                        src = new Pair(i, j);
                        break;
                    case 'H':
                        tgt = new Pair(i, j);
                        break;
                }
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        int[][] dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        q.offer(src);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == tgt.y && cur.x == tgt.x) return mat[tgt.y][tgt.x];

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= y || nx < 0 || nx >= x || mat[ny][nx] != 0) continue;

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
