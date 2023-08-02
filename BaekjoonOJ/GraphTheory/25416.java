import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] arr = new int[5][5];
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) arr[i][j] = read();

        bfs(new Node(read(), read(), 0));

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void bfs(Node src) {
        Queue<Node> q = new LinkedList<>();

        q.offer(src);
        arr[src.y][src.x] = -1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];

                if (ny < 0 || ny > 4 || nx < 0 || nx > 4 || arr[ny][nx] == -1) continue;

                if (arr[ny][nx] == 1) {
                    cnt = cur.cnt + 1;
                    return;
                }

                q.offer(new Node(ny, nx, cur.cnt + 1));
                arr[ny][nx] = -1;
            }
        }
    }

    private static class Node {
        int y, x, cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;

        boolean flag = n == 13;
        if (flag) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
