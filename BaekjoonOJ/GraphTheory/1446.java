import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dist = new int[d + 1];
        List<Pair>[] graph = new ArrayList[10001];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (dest - src > weight)
                graph[dest].add(new Pair(src, weight));
        }

        dist[0] = 0;
        for (int i = 1; i <= d; i++) {
            if (graph[i].size() > 0) {
                for (Pair src : graph[i]) {
                    if (dist[src.node] + src.weight > dist[i])
                        continue;
                    dist[i] = Math.min(dist[i - 1] + 1, dist[src.node] + src.weight);
                }
            } else
                dist[i] = dist[i - 1] + 1;
        }

        bw.write(String.valueOf(dist[d]));
        bw.flush();
    }

    private static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
