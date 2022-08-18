import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, w;
    static int[] dist;
    static List<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            list = new ArrayList<>();

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (i < m) {
                    list.add(new Edge(src, dest, weight));
                    list.add(new Edge(dest, src, weight));
                } else
                    list.add(new Edge(src, dest, weight * -1));
            }

            bw.write((bellmanFord() ? "YES" : "NO") + "\n");
        }

        bw.flush();
    }

    private static boolean bellmanFord() {
        for (int i = 1; i <= n; i++) {
            for (Edge edge : list) {
                if (dist[edge.dest] > dist[edge.src] + edge.weight) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;

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
