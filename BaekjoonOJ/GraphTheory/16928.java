import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, res;
    static Map<Integer, Integer> map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        visit = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            map.put(src, dest);
        }

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 0));
        visit[1] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.node == 100) {
                res = now.cnt;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now.node + i;
                if (next <= 100 && !visit[next]) {
                    visit[next] = true;
                    if (map.containsKey(next))
                        next = map.get(next);

                    q.offer(new Pair(next, now.cnt + 1));
                }
            }
        }
    }

    private static class Pair {
        int node, cnt;

        public Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

}
