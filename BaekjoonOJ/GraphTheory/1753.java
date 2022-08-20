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

    static int[] dist;
    static List<Edge>[] list;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        dist = new int[v + 1];
        list = new ArrayList[v + 1];

        Arrays.fill(dist, inf);

        for (int i = 1; i <= v; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[src].add(new Edge(dest, weight));
        }

        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == inf)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }

        bw.flush();
    }

    private static void dijkstra(int source) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.weight > dist[now.node])
                continue;

            int src = now.node;
            for (Edge dest : list[src]) {
                if (dist[dest.node] > dist[src] + dest.weight) {
                    dist[dest.node] = dist[src] + dest.weight;

                    pq.offer(new Edge(dest.node, dist[dest.node]));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

}
