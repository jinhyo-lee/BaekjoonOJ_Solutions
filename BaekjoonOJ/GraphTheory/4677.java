import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static char[][] grid;
    static int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1}, dx = {0, 0, -1, 1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()).charAt(0) != '0') {
            st = new StringTokenizer(input);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            grid = new char[m][n];
            for (int i = 0; i < m; i++)
                grid[i] = br.readLine().toCharArray();

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '@') {
                        bfs(new Pair(i, j));
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(Pair src) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n)
                    continue;

                if (grid[ny][nx] == '@') {
                    grid[ny][nx] = '*';
                    q.offer(new Pair(ny, nx));
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
