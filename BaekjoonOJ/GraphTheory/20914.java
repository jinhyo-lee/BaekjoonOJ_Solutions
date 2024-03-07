import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}};
    static int[][] mat = {{1, 0}, {2, 4}, {2, 2}, {1, 2}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {0, 7}, {1, 6}, {1, 7}, {1, 8}, {2, 6}, {2, 5}, {0, 8}, {0, 9}, {0, 0}, {0, 3}, {1, 1}, {0, 4}, {0, 6}, {2, 3}, {0, 1}, {2, 1}, {0, 5}, {2, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int cnt = 1;
            for (int i = 1; i < s.length(); i++) cnt += bfs(mat[s.charAt(i - 1) - 'A'], mat[s.charAt(i) - 'A']) + 1;

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static int bfs(int[] src, int[] dest) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[3][10];

        q.offer(new Node(src[0], src[1], 0));
        visit[src[0]][src[1]] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.y == dest[0] && cur.x == dest[1]) return cur.cnt * 2;

            for (int[] d : dir) {
                int ny = cur.y + d[0];
                int nx = cur.x + d[1];
                if (ny < 0 || ny >= 3 || nx < 0 || nx >= 10 || visit[ny][nx]) continue;

                q.offer(new Node(ny, nx, cur.cnt + 1));
                visit[ny][nx] = true;
            }
        }

        return 0;
    }

    private static class Node {
        int y, x, cnt;

        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

}
