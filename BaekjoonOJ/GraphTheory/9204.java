import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] arr = new boolean[8][8];
    static int[] dy = {-1, -1, 1, 1}, dx = {-1, 1, 1, -1};
    static int y, x;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read();

        while (t-- > 0) {
            Node src = new Node(read() - 1, read() - 1, "");
            y = read() - 1;
            x = read() - 1;

            if ((src.y + src.x) % 2 != (y + x) % 2) sb.append("Impossible");
            else if (src.y == y && src.x == x) sb.append("0 ").append((char) (y + 65)).append(" ").append(x + 1);
            else bfs(src);

            sb.append("\n");
            if (t > 0) for (boolean[] b : arr) Arrays.fill(b, false);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(Node src) {
        Queue<Node> q = new LinkedList<>();

        q.offer(src);
        arr[src.y][src.x] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y, nx = cur.x;
                while (true) {
                    ny += dy[i];
                    nx += dx[i];

                    if (ny < 0 || ny > 7 || nx < 0 || nx > 7) break;

                    if (ny == y && nx == x) {
                        sb.append(cur.trace.length() / 4).append(" ").append(cur.trace).append(append(y, x));
                        return;
                    }

                    if (!arr[ny][nx]) {
                        q.offer(new Node(ny, nx, cur.trace));
                        arr[ny][nx] = true;
                    }
                }
            }
        }
    }

    private static class Node {
        int y, x;
        String trace;

        public Node(int y, int x, String trace) {
            this.y = y;
            this.x = x;
            this.trace = trace + append(y, x);
        }
    }

    private static String append(int y, int x) {
        return (char) (y + 65) + " " + (x + 1) + " ";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
