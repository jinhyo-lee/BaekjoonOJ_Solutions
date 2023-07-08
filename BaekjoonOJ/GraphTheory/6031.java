import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static char[][] arr;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1}, dx = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new char[h][w];
        for (int i = 0; i < h; i++)
            arr[i] = br.readLine().toCharArray();

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                if (arr[i][j] == '.') max = Math.max(max, bfs(i, j));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        arr[y][x] = ' ';

        int cnt = 1;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = pair.y + dy[i];
                int nx = pair.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;

                if (arr[ny][nx] == '.' && arr[ny][nx] != ' ') {
                    arr[ny][nx] = ' ';
                    q.offer(new Pair(ny, nx));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
