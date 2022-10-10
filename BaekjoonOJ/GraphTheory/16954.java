import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] map;
    static boolean[][][] visit;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1, 0};
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[8][8];
        visit = new boolean[8][8][9];

        for (int i = 0; i < 8; i++)
            map[i] = br.readLine().toCharArray();

        bw.write(bfs() ? "1" : "0");
        bw.flush();
    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(7, 0, 0));
        visit[7][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int cnt = cur.cnt;

            if (cur.y == 0 && cur.x == 7)
                return true;

            for (int i = 0; i < 9; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nCnt = Math.min(cnt + 1, 8);

                if (ny < 0 || ny >= 8 || nx < 0 || nx >= 8)
                    continue;
                if (ny - cnt >= 0 && map[ny - cnt][nx] == '#')
                    continue;
                if (ny - cnt - 1 >= 0 && map[ny - cnt - 1][nx] == '#')
                    continue;

                if (!visit[ny][nx][nCnt]) {
                    visit[ny][nx][nCnt] = true;
                    q.offer(new Node(ny, nx, nCnt));
                }
            }
        }

        return false;
    }

    private static class Node {
        int y, x, cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

}
