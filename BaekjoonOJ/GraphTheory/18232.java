import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read(), s = read(), e = read();

        graph = new Node[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new Node(i);

        while (m-- > 0) {
            int x = read(), y = read();
            graph[x].addEdge(y);
            graph[y].addEdge(x);
        }

        bw.write(String.valueOf(bfs(n, s, e)));
        bw.flush();
    }

    private static int bfs(int n, int s, int e) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(s, 0));

        while (!q.isEmpty()) {
            Pair src = q.poll();
            if (src.node == e) return src.cnt;

            for (int tgt : graph[src.node].adj) if (tgt <= n && !visit[tgt]) q.offer(new Pair(tgt, src.cnt + 1));
            if (src.node < n && !visit[src.node + 1]) q.offer(new Pair(src.node + 1, src.cnt + 1));
            if (src.node > 1 && !visit[src.node - 1]) q.offer(new Pair(src.node - 1, src.cnt + 1));
        }

        return 0;
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }

        public void addEdge(int tgt) {
            adj.add(tgt);
        }
    }

    private static class Pair {
        int node, cnt;

        Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
            visit[node] = true;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
