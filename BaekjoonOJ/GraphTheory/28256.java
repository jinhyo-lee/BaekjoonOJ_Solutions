import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] mat = new char[3][3];
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < 3; i++) mat[i] = br.readLine().toCharArray();
            for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (mat[i][j] == 'O') bfs(i, j);

            sb.append(isProper(new StringTokenizer(br.readLine())) ? "1" : "0").append("\n");
            list.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(y, x));
        mat[y][x] = 'X';

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i], nx = cur.x + dx[i];
                if (ny < 0 || ny >= 3 || nx < 0 || nx >= 3 || mat[ny][nx] != 'O') continue;

                q.offer(new Pair(ny, nx));
                mat[ny][nx] = 'X';
            }
        }

        list.add(cnt);
    }

    private static boolean isProper(StringTokenizer st) {
        int n = Integer.parseInt(st.nextToken());
        if (n != list.size()) return false;

        Collections.sort(list);
        for (int i = 0; i < n; i++) if (list.get(i) != Integer.parseInt(st.nextToken())) return false;

        return true;
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
