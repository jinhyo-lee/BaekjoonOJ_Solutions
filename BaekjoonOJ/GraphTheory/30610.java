import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt;
    static boolean[][] mat;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        mat = new boolean[n = Integer.parseInt(st.nextToken())][m = Integer.parseInt(st.nextToken())];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) mat[i][j] = s.charAt(j) == '1';
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!mat[i][j]) continue;
                dfs(i, j);
                list.add(cnt);
                cnt = 0;
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i : list) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int y, int x) {
        mat[y][x] = false;
        cnt++;

        for (int[] dir : dir) {
            int ny = y + dir[0], nx = x + dir[1];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || !mat[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

}
