import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int m, n;
    static char[][] arr;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}, dx = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        m = read();
        n = read();

        arr = new char[m][n];
        for (int i = 0; i < m; i++) arr[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '#') {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        arr[y][x] = '.';

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];

                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;

                if (arr[ny][nx] == '#') {
                    q.offer(new Pair(ny, nx));
                    arr[ny][nx] = '.';
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

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
