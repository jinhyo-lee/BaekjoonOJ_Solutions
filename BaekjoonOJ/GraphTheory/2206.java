import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] visit;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));
        visit[0][0] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.y == n - 1 && now.x == m - 1)
                return now.dist;

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (visit[ny][nx] <= now.broken)
                    continue;

                if (map[ny][nx] == '0') {
                    visit[ny][nx] = now.broken;
                    q.offer(new Node(ny, nx, now.dist + 1, now.broken));
                } else {
                    if (now.broken == 0) {
                        visit[ny][nx] = now.broken + 1;
                        q.offer(new Node(ny, nx, now.dist + 1, now.broken + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static class Node {
        int y, x, dist, broken;

        public Node(int y, int x, int dist, int broken) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.broken = broken;
        }
    }

}
