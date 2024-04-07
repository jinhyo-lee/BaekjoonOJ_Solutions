import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static Node[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read() + 1, m = read();
        graph = new Node[n];
        dist = new int[n];

        for (int i = 1; i < n; i++) {
            graph[i] = new Node(i);
            dist[i] = -1;
        }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < n; j++) if (read() == 1) graph[i].adj.add(j);

        bfs(m);

        int max = 0;
        for (int i = 1; i < n; i++) max = Math.max(max, dist[i]);

        for (int i = 0; i <= max; i++, sb.append("\n"))
            for (int j = 1; j < n; j++) if (dist[j] == i) sb.append(j).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        dist[root] = 0;

        while (!q.isEmpty()) {
            int src = q.poll();
            for (int tgt : graph[src].adj) {
                if (dist[tgt] == -1) {
                    q.offer(tgt);
                    dist[tgt] = dist[src] + 1;
                }
            }
        }
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
