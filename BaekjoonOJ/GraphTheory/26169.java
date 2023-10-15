import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat = new int[5][5];
    static boolean[][] visit = new boolean[5][5];
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) mat[i][j] = read();

        bw.write(dfs(read(), read(), 0, 0) ? "1" : "0");
        bw.flush();
    }

    private static boolean dfs(int y, int x, int depth, int cnt) {
        if (mat[y][x] == 1) cnt++;
        if (cnt == 2) return true;
        if (depth == 3) return false;

        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || visit[ny][nx] || mat[ny][nx] == 131) continue;

            if (dfs(ny, nx, depth + 1, cnt)) return true;
        }

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
