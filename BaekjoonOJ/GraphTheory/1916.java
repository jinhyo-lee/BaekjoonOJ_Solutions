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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        list = new ArrayList[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[src].add(new Edge(dest, weight));
        }

        st = new StringTokenizer(br.readLine());
        int source = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dijkstra(source);

        bw.write(dist[destination] + "\n");
        bw.flush();
    }

    private static void dijkstra(int source) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

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

    private static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
