import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[][] arr;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            arr = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                s = br.readLine();
                for (int j = 0; j < n; j++) arr[i][j] = s.charAt(j) == '1';
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append("Case #").append(t++).append(": ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int y, int x) {
        arr[y][x] = false;

        for (int[] dir : dir) {
            int ny = y + dir[0], nx = x + dir[1];
            if (ny < 0 || ny >= arr.length || nx < 0 || nx >= arr.length || !arr[ny][nx]) continue;

            dfs(ny, nx);
        }
    }

}
