import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int res = bfs();

        bw.write(res == -1 ? "use the stairs" : String.valueOf(res));
        bw.flush();
    }

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visit = new boolean[f + 1];

        q.offer(new Pair(s, 0));
        visit[s] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            int floor = cur.floor;
            int cnt = cur.cnt;

            if (floor == g)
                return cnt;

            if (floor + u <= f && !visit[floor + u]) {
                visit[floor + u] = true;
                q.offer(new Pair(floor + u, cnt + 1));
            }
            if (floor - d > 0 && !visit[floor - d]) {
                visit[floor - d] = true;
                q.offer(new Pair(floor - d, cnt + 1));
            }
        }

        return -1;
    }

    private static class Pair {
        int floor, cnt;

        public Pair(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

}
