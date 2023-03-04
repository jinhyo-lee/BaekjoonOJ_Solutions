import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, max;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][k];
        visit = new boolean[101];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        recur(0, 1);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int depth, int idx) {
        if (depth == n) {
            int cnt = 0;
            loop:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    if (!visit[arr[i][j]])
                        continue loop;
                }
                cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }

        for (int i = idx; i <= n * 2; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            recur(depth + 1, i + 1);
            visit[i] = false;
        }
    }

}
