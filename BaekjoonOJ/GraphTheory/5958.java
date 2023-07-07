import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static char[][] arr;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '*') {
                    cnt++;
                    bfs(i, j);
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
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                if (arr[ny][nx] == '*') {
                    arr[ny][nx] = '.';
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
