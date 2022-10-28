import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Edge>[] list;
    static final int inf = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[src].add(new Edge(dest, weight));
            list[dest].add(new Edge(src, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);
        int res = Math.min(path1, path2);

        bw.write(String.valueOf(res >= inf ? -1 : res));
        bw.flush();
    }

    private static int dijkstra(int src, int dest) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int[] dist = new int[n + 1];

        pq.offer(new Edge(src, 0));
        Arrays.fill(dist, inf);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int cur = edge.node;

            for (Edge next : list[cur]) {
                if (dist[next.node] > dist[cur] + next.weight) {
                    dist[next.node] = dist[cur] + next.weight;
                    pq.offer(next);
                }
            }
        }

        return dist[dest];
    }

    private static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
