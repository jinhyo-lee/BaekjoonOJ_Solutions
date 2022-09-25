import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, k, max;
    static boolean[][] word;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k >= 5) {
            word = new boolean[n][26];
            visit = new boolean[26];

            for (int i = 0; i < n; i++) {
                for (char c : br.readLine().toCharArray())
                    word[i][c - 'a'] = true;
            }

            recur(0, 0);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int idx, int depth) {
        if (depth == k) {
            max = Math.max(max, getCount());
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recur(i, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static int getCount() {
        int cnt = 0;

        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < 26; j++) {
                if (word[i][j] && !visit[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                cnt++;
        }

        return cnt;
    }

}
