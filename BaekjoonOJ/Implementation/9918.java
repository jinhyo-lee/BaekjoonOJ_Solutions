import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat = new int[7][7];
    static boolean[][] visit = new boolean[7][7];
    static int[] face = new int[6], dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = 0, x = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if ((mat[i][j] = read()) == 0 && y > 0) continue;
                y = i;
                x = j;
            }
        }

        dfs(y, x, 0, 1, 2, 3, 4, 5);

        int n = 0;
        boolean flag = true;
        for (int i = 0; i < 6; i++) {
            if (face[i] == 0) {
                flag = false;
                break;
            }
            if (face[i] == 1) n = face[i ^ 1];
        }

        bw.write(flag ? String.valueOf(n) : "0");
        bw.flush();
    }

    static void dfs(int y, int x, int u, int d, int f, int b, int l, int r) {
        face[d] = mat[y][x];
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny >= 1 && ny <= 6 && nx >= 1 && nx <= 6 && !visit[ny][nx] && mat[ny][nx] > 0) {
                if (i == 0) dfs(ny, nx, f, b, d, u, l, r);
                else if (i == 1) dfs(ny, nx, b, f, u, d, l, r);
                else if (i == 2) dfs(ny, nx, r, l, f, b, u, d);
                else dfs(ny, nx, l, r, f, b, d, u);
            }
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
