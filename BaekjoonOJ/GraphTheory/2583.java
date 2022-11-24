import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static boolean[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int bx = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());

            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            for (int x = bx; x < tx; x++) {
                for (int y = by; y < ty; y++)
                    map[x][y] = true;
            }
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }

        bw.write(cnt + "\n");

        Collections.sort(list);
        for (int i : list)
            bw.write(i + " ");

        bw.flush();
    }

    private static int bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));

        map[y][x] = true;
        int sum = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (!map[ny][nx]) {
                    map[ny][nx] = true;
                    sum++;
                    q.offer(new Node(ny, nx));
                }
            }
        }

        return sum;
    }

    private static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
