import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] scv;
    static int[][][] dp;
    static int[][] pattern = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
    static int minCnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        scv = new int[3];
        dp = new int[61][61][61];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            scv[i] = Integer.parseInt(st.nextToken());

        recur(scv, 0);

        bw.write(String.valueOf(minCnt));
        bw.flush();
    }

    private static void recur(int[] scv, int cnt) {
        if (minCnt <= cnt)
            return;
        if (dp[scv[0]][scv[1]][scv[2]] != 0 && dp[scv[0]][scv[1]][scv[2]] <= cnt)
            return;

        if (scv[0] == 0 && scv[1] == 0 && scv[2] == 0) {
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        dp[scv[0]][scv[1]][scv[2]] = cnt;

        for (int i = 0; i < 6; i++)
            recur(new int[]{Math.max(scv[0] + pattern[i][0], 0), Math.max(scv[1] + pattern[i][1], 0), Math.max(scv[2] + pattern[i][2], 0)}, cnt + 1);
    }

}
