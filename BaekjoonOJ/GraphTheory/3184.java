import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c, o, v, oCnt, vCnt;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#')
                    bfs(i, j);
            }
        }

        bw.write(o + " " + v);
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));

        oCnt = vCnt = 0;
        check(y, x);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c || map[ny][nx] == '#')
                    continue;

                check(ny, nx);

                q.offer(new Node(ny, nx));
            }
        }

        if (oCnt > vCnt)
            o += oCnt;
        else
            v += vCnt;
    }

    private static void check(int y, int x) {
        if (map[y][x] == 'o')
            oCnt++;
        else if (map[y][x] == 'v')
            vCnt++;

        map[y][x] = '#';
    }

    private static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
