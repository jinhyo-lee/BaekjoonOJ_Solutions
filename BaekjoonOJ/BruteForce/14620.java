import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        n--;
        dfs(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void dfs(int sum, int depth) {
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!check(i, j)) continue;

                toggle(i, j, true);
                dfs(sum + sum(i, j), depth + 1);
                toggle(i, j, false);
            }
        }
    }

    private static boolean check(int y, int x) {
        if (visit[y][x]) return false;

        for (int i = 0; i < 4; i++)
            if (visit[y + dy[i]][x + dx[i]]) return false;

        return true;
    }

    private static int sum(int y, int x) {
        int sum = arr[y][x];

        for (int i = 0; i < 4; i++)
            sum += arr[y + dy[i]][x + dx[i]];

        return sum;
    }

    private static void toggle(int y, int x, boolean flag) {
        visit[y][x] = flag;

        for (int i = 0; i < 4; i++)
            visit[y + dy[i]][x + dx[i]] = flag;
    }

}
