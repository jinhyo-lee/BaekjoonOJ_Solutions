import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static boolean[][] mat, visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            sb.append("Case #").append(tc).append(":\n");

            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            mat = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < c; j++) mat[i][j] = s.charAt(j) == '1';
            }

            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().charAt(0) == 'Q') {
                    visit = new boolean[r][c];
                    int cnt = 0;
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (mat[i][j] && !visit[i][j]) {
                                dfs(i, j);
                                cnt++;
                            }
                        }
                    }
                    sb.append(cnt).append("\n");
                } else
                    mat[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0) == '1';
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        for (int[] d : dir) {
            int ny = y + d[0], nx = x + d[1];
            if (ny < 0 || ny >= r || nx < 0 || nx >= c || !mat[ny][nx] || visit[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

}
