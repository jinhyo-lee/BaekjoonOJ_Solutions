import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, total;
    static int[] value;
    static int[][] map;
    static boolean[] subset;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        value = new int[n + 1];
        map = new int[n + 1][n + 1];
        subset = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            total += value[i];
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++)
                map[i][Integer.parseInt(st.nextToken())] = 1;
        }

        recur(1, 0);

        bw.write((min == Integer.MAX_VALUE ? -1 : min) + "\n");
        bw.flush();
    }

    private static void recur(int idx, int sum) {
        if (idx > n) {
            if (isConnected(true) && isConnected(false))
                min = Math.min(min, Math.abs(sum - (total - sum)));

            return;
        }

        subset[idx] = true;
        recur(idx + 1, sum + value[idx]);
        subset[idx] = false;
        recur(idx + 1, sum);
    }

    private static boolean isConnected(boolean flag) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (subset[i] == flag) {
                q.offer(i);
                visit[i] = true;
                break;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 1; i <= n; i++) {
                if (subset[i] == flag && map[node][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (subset[i] == flag && !visit[i])
                return false;
        }

        return true;
    }

}
