import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int min = Integer.MAX_VALUE;
    static List<Node> list = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int total = n * m;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    list.add(new Node(i, j, 1, new int[][]{{1}, {2}, {3}, {0}}));
                if (map[i][j] == 2)
                    list.add(new Node(i, j, 2, new int[][]{{1, 3}, {0, 2}}));
                if (map[i][j] == 3)
                    list.add(new Node(i, j, 3, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}}));
                if (map[i][j] == 4)
                    list.add(new Node(i, j, 4, new int[][]{{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}}));
                if (map[i][j] == 5)
                    list.add(new Node(i, j, 5, new int[][]{{0, 1, 2, 3}}));
                if (map[i][j] == 6)
                    total--;
            }
        }

        recur(total - list.size(), 0, map);

        bw.write(min + "\n");
        bw.flush();
    }

    private static void recur(int cnt, int idx, int[][] map) {
        if (idx == list.size()) {
            min = Math.min(min, cnt);
            return;
        }

        int[][] copy = new int[n][m];
        copy(copy, map);

        Node cam = list.get(idx);
        for (int i = 0; i < cam.dir.length; i++) {
            int observe = 0;
            for (int j = 0; j < cam.dir[i].length; j++)
                observe += operate(cam.y, cam.x, cam.dir[i][j], map);

            recur(cnt - observe, idx + 1, map);
            copy(map, copy);
        }
    }

    private static int operate(int y, int x, int dir, int[][] map) {
        int cnt = 0;

        while (true) {
            y += dy[dir];
            x += dx[dir];

            if (y < 0 || x < 0 || y >= n || x >= m || map[y][x] == 6)
                return cnt;
            if (map[y][x] >= 1 && map[y][x] <= 5 || map[y][x] == -1)
                continue;

            map[y][x] = -1;
            cnt++;
        }
    }

    private static void copy(int[][] copy, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                copy[i][j] = map[i][j];
        }
    }

    private static class Node {
        int y, x, type;
        int[][] dir;

        public Node(int y, int x, int type, int[][] dir) {
            this.y = y;
            this.x = x;
            this.type = type;
            this.dir = dir;
        }
    }

}
