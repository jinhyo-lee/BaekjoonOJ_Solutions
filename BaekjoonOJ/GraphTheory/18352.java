import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, x;
    static boolean[] visit;
    static List<Integer>[] list;
    static PriorityQueue<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            list[src].add(dest);
        }

        bfs();

        if (!result.isEmpty()) {
            while (!result.isEmpty())
                bw.write(result.poll() + "\n");
        } else
            bw.write("-1");

        bw.flush();
    }

    private static void bfs() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        result = new PriorityQueue<>();

        pq.offer(new Pair(x, 0));
        visit[x] = true;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int src = cur.node;
            int weight = cur.weight;

            if (weight == k) {
                result.offer(src);
                continue;
            }

            for (int dest : list[src]) {
                if (!visit[dest]) {
                    visit[dest] = true;
                    pq.offer(new Pair(dest, weight + 1));
                }
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }

}
