import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++)
            arr[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j])
                    continue;

                dfs(i, j);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int y, int x) {
        visit[y][x] = true;

        if (arr[y][x] == '|') {
            y++;
            if (y < n && arr[y][x] == '|')
                dfs(y, x);
        } else {
            x++;
            if (x < m && arr[y][x] == '-')
                dfs(y, x);
        }
    }

}
