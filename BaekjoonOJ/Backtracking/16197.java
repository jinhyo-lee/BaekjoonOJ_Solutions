package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P16197 {

    static int n, m;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int min = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        Node a = null;
        Node b = null;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'o') {
                    if (flag)
                        a = new Node(i, j);
                    else
                        b = new Node(i, j);
                    flag = true;
                }
            }
        }

        recur(a, b, 0);

        bw.write(String.valueOf(min == 11 ? -1 : min));
        bw.flush();
    }

    private static void recur(Node a, Node b, int cnt) {
        if (cnt > min || cnt > 10)
            return;

        for (int i = 0; i < 4; i++) {
            int ay = a.y + dy[i];
            int ax = a.x + dx[i];
            int by = b.y + dy[i];
            int bx = b.x + dx[i];

            int drop = 0;
            if (ay < 0 || ax < 0 || ay >= n || ax >= m)
                drop++;
            if (by < 0 || bx < 0 || by >= n || bx >= m)
                drop++;

            if (drop == 2)
                continue;
            if (drop == 1) {
                min = Math.min(min, cnt + 1);
                return;
            }

            if (map[ay][ax] == '#') {
                ay = a.y;
                ax = a.x;
            }
            if (map[by][bx] == '#') {
                by = b.y;
                bx = b.x;
            }

            recur(new Node(ay, ax), new Node(by, bx), cnt + 1);
        }
    }

    private static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
