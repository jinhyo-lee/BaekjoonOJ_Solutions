import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map, path;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        path = new int[n][m];

        int y = 0, x = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    path[i][j] = -1;
                else if (map[i][j] == 2) {
                    y = i;
                    x = j;
                }
            }
        }

        bfs(y, x);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                bw.write(path[i][j] + " ");
            bw.write("\n");
        }

        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (map[ny][nx] == 1 && path[ny][nx] == -1) {
                    path[ny][nx] = cur.dist + 1;
                    q.offer(new Node(ny, nx, cur.dist + 1));
                }
            }
        }
    }

    private static class Node {
        int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

}
