import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] dist;
    static List<Edge> list;
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            dist[i] = inf;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(src, dest, weight));
        }

        if (bellmanFord(1))
            bw.write(-1 + "\n");
        else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == inf)
                    bw.write(-1 + "\n");
                else
                    bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
    }

    private static boolean bellmanFord(int root) {
        dist[root] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int s = list.get(j).src;
                int d = list.get(j).dest;
                int w = list.get(j).weight;

                if (dist[s] != inf && dist[d] > dist[s] + w) {
                    dist[d] = dist[s] + w;

                    if (i == n)
                        return true;
                }
            }
        }

        return false;
    }

    private static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

}
