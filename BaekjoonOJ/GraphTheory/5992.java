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

        int p = read();
        graph = new Node[p + 1];
        dist = new int[p + 1];
        for (int i = 0; i <= p; i++) {
            graph[i] = new Node(i);
            dist[i] = -1;
        }

        while (p-- > 1) {
            int u = read(), v;
            if ((v = read()) != 0) graph[u].adj.add(v);
            if ((v = read()) != 0) graph[u].adj.add(v);
        }

        bfs();

        int max = 0;
        for (int i : dist) max = Math.max(max, i);

        bw.write(String.valueOf(max + 1));
        bw.flush();
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u].adj) {
                if (dist[v] == -1) {
                    q.offer(v);
                    dist[v] = dist[u] + 1;
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
