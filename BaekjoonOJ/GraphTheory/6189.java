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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Queue<Pair> q = new ArrayDeque<>();
        int[][] mat = new int[n][m], dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int y = 0, x = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '*':
                        mat[i][j] = -1;
                        break;
                    case 'B':
                        q.offer(new Pair(i, j));
                        break;
                    case 'C':
                        y = i;
                        x = j;
                        break;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.y == y && cur.x == x) break;

            for (int[] d : dir) {
                int ny = cur.y + d[0], nx = cur.x + d[1];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || mat[ny][nx] != 0) continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = mat[cur.y][cur.x] + 1;
            }
        }

        bw.write(String.valueOf(mat[y][x]));
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
