import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int w, h, cnt;
    static char[][] mat;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        mat = new char[h][w];
        for (int i = 0; i < h; i++) mat[i] = br.readLine().toCharArray();

        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (mat[i][j] == '*') {
                    cnt = 0;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void dfs(int y, int x) {
        for (int[] d : dir) {
            int ny = y + d[0], nx = x + d[1];
            if (ny < 0 || ny >= h || nx < 0 || nx >= w || mat[ny][nx] == '.') continue;

            mat[ny][nx] = '.';
            cnt++;
            dfs(ny, nx);
        }
    }

}
