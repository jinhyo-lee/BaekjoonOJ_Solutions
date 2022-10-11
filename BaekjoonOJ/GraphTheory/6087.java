import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h, res;
    static char[][] map;
    static int[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Node src, dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visit = new int[h][w];

        boolean flag = false;
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') {
                    if (!flag) {
                        src = new Node(i, j, -1, 0);
                        flag = true;
                    } else
                        dest = new Node(i, j, -1, 0);
                }
            }
        }

        for (int i = 0; i < h; i++)
            Arrays.fill(visit[i], h * w);

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void bfs() {
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.offer(src);
        visit[src.y][src.x] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.y == dest.y && cur.x == dest.x) {
                res = cur.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nCnt = cur.cnt;

                if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == '*')
                    continue;

                if (cur.dir != i && cur.dir != -1)
                    nCnt++;

                if (visit[ny][nx] < nCnt)
                    continue;

                visit[ny][nx] = nCnt;
                q.offer(new Node(ny, nx, i, nCnt));
            }
        }
    }

    private static class Node {
        int y, x, dir, cnt;

        public Node(int y, int x, int dir, int cnt) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

}
