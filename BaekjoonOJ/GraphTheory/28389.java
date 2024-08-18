import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] mat;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static Map<Integer, String> map = init();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        mat = new boolean[n = Integer.parseInt(st.nextToken())][m = Integer.parseInt(st.nextToken())];

        int y = 0, x = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'x') mat[i][j] = true;
                else if (c == 'P') {
                    y = i;
                    x = j;
                }
            }
        }

        dfs(y, x);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int y, int x) {
        mat[y][x] = false;
        for (int i = 0; i < dir.length; i++) {
            int ny = y + dir[i][0], nx = x + dir[i][1];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || !mat[ny][nx]) continue;

            sb.append(map.get(i));
            dfs(ny, nx);
            return;
        }
    }

    private static Map<Integer, String> init() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "dolje\n");
        map.put(1, "gore\n");
        map.put(2, "lijevo\n");
        map.put(3, "desno\n");

        return map;
    }

}
