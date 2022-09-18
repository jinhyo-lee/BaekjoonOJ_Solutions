import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] stat;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        stat = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                stat[i][j] = Integer.parseInt(st.nextToken());
        }

        recur(1, 0);

        bw.write(min + "\n");
        bw.flush();
    }

    private static void recur(int idx, int depth) {
        if (depth == n / 2) {
            minimize();
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recur(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void minimize() {
        int start = 0;
        int link = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visit[i] && visit[j])
                    start += stat[i][j];
                else if (!visit[i] && !visit[j])
                    link += stat[i][j];
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }

}
