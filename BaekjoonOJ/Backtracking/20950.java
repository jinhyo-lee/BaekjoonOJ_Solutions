import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int[] src, tgt;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        src = new int[3];
        tgt = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            src[i] = Integer.parseInt(st.nextToken());

        recur(0, 0);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void recur(int depth, int cnt) {
        if (cnt >= 2)
            min = Math.min(min, getColor(cnt));

        for (int i = depth; i < n; i++) {
            if (visit[i] || cnt > 6)
                continue;

            visit[i] = true;
            for (int j = 0; j < 3; j++)
                tgt[j] += arr[i][j];

            recur(i + 1, cnt + 1);

            visit[i] = false;
            for (int j = 0; j < 3; j++)
                tgt[j] -= arr[i][j];
        }
    }

    private static int getColor(int cnt) {
        int res = 0;
        for (int i = 0; i < 3; i++)
            res += Math.abs(tgt[i] / cnt - src[i]);

        return res;
    }

}
