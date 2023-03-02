import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max;
    static Pair[] pairs;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        visit = new boolean[n + 1];

        recur(0, 0);

        max *= 2;
        if (max < n)
            max++;

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int depth, int cnt) {
        if (depth == m) {
            max = Math.max(max, cnt);
            return;
        }

        if (visit[pairs[depth].x] || visit[pairs[depth].y])
            recur(depth + 1, cnt);
        else {
            visit[pairs[depth].x] = true;
            visit[pairs[depth].y] = true;
            recur(depth + 1, cnt + 1);

            visit[pairs[depth].x] = false;
            visit[pairs[depth].y] = false;
            recur(depth + 1, cnt);
        }
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
