import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat = new int[7][7], pos = new int[7][2];
    static boolean[][] visit = new boolean[7][7];
    static int[] face = new int[7], dy = {-1, 0, 1, 0}, dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if ((mat[i][j] = read()) == 0) continue;
                pos[mat[i][j]][0] = i;
                pos[mat[i][j]][1] = j;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (pos[i][0] == 0 && pos[i][1] == 0) continue;
            visit[i][i] = true;
            dfs(0, -1, pos[i][0], pos[i][1], i);
        }

        boolean flag = true;
        for (int i = 1; i <= 6; i++) {
            if (face[i] != 0) continue;
            flag = false;
            break;
        }

        bw.write(flag ? String.valueOf(face[1]) : "0");
        bw.flush();
    }

    static void dfs(int depth, int dir, int y, int x, int cur) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (ny < 1 || ny > 6 || nx < 1 || nx > 6) continue;

            int next = mat[ny][nx];
            if (next > 0 && !visit[cur][next]) {
                visit[cur][next] = true;
                if (dir == -1) dfs(1, i, ny, nx, cur);
                else if (dir == i && depth == 1 && (face[cur] == 0 || face[cur] == next) && (face[next] == 0 || face[next] == cur)) {
                    face[cur] = next;
                    face[next] = cur;
                    dfs(depth + 1, dir, ny, nx, cur);
                } else dfs(depth, dir, ny, nx, cur);
            }
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
