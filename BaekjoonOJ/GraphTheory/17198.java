import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new int[10][10];
        int y = 0, x = 0;

        for (int i = 0; i < 10; i++) {
            String input = br.readLine();
            for (int j = 0; j < 10; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'B') {
                    y = i;
                    x = j;
                }
            }
        }

        bw.write(String.valueOf(bfs(y, x)));
        bw.flush();
    }

    private static int bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(y, x));
        map[y][x] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= 10 || nx < 0 || nx >= 10)
                    continue;

                if (map[ny][nx] == 'L')
                    return map[cur.y][cur.x];

                if (map[ny][nx] == '.') {
                    map[ny][nx] = map[cur.y][cur.x] + 1;
                    q.offer(new Pair(ny, nx));
                }
            }
        }

        return 0;
    }

    private static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
