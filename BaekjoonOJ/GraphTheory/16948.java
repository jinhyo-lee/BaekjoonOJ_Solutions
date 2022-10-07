import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, r1, c1, r2, c2, res;
    static boolean[][] visit;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r1, c1, 0));
        visit[r1][c1] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.y == r2 && now.x == c2) {
                res = now.cnt;
                return;
            }

            for (int i = 0; i < 6; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visit[ny][nx])
                    continue;

                q.offer(new Node(ny, nx, now.cnt + 1));
                visit[ny][nx] = true;
            }
        }

        res = -1;
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
