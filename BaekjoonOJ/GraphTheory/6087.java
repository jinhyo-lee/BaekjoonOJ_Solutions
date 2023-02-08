import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static char[][] map;
    static int[][][] visit;
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
        visit = new int[h][w][4];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 4; k++)
                    visit[i][j][k] = Integer.MAX_VALUE;

                if (map[i][j] == 'C') {
                    if (src == null)
                        src = new Node(i, j, -1, 0);
                    else
                        dest = new Node(i, j, -1, 0);
                }
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(src);

        int min = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.y == dest.y && cur.x == dest.x) {
                min = Math.min(min, cur.cnt);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nCnt = cur.cnt;

                if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == '*')
                    continue;

                if (cur.dir != i && cur.dir != -1)
                    nCnt++;

                if (visit[ny][nx][i] <= nCnt)
                    continue;

                visit[ny][nx][i] = nCnt;
                pq.offer(new Node(ny, nx, i, nCnt));
            }
        }

        return min;
    }

    private static class Node implements Comparable<Node> {
        int y, x, dir, cnt;

        public Node(int y, int x, int dir, int cnt) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }

}
