import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int k, max;
    static int[] cost, type;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[7];
        type = new int[n];
        visit = new boolean[7];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 7; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            type[i] = Integer.parseInt(st.nextToken());

        recur(1);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int idx) {
        if (idx == 7) {
            int remain = k, cnt = 0;
            for (int t : type) {
                if (!visit[t])
                    continue;
                if (remain < cost[t])
                    break;

                remain -= cost[t];
                cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        visit[idx] = true;
        recur(idx + 1);
        visit[idx] = false;
        recur(idx + 1);
    }

}
