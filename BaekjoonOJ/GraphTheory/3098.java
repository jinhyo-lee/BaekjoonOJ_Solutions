import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    static Node[] graph;
    static Set<Pair> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read(), total = m * 2, limit = n * (n - 1);

        graph = new Node[n];
        while (n-- > 0) graph[n] = new Node(n);

        while (m-- > 0) {
            int a = read() - 1, b = read() - 1;
            graph[a].addEdge(b);
            graph[b].addEdge(a);
        }

        StringBuilder sb = new StringBuilder("\n");
        int cnt = 0;
        while (total < limit) {
            search();

            total += set.size() * 2;
            sb.append(set.size()).append("\n");
            cnt++;

            set.clear();
        }

        bw.write(cnt + sb.toString());
        bw.flush();
    }

    private static void search() {
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i].adj) {
                for (int k : graph[j].adj)
                    if (i != k && !graph[i].adj.contains(k)) set.add(i < k ? new Pair(i, k) : new Pair(k, i));
            }
        }

        for (Pair p : set) {
            graph[p.a].addEdge(p.b);
            graph[p.b].addEdge(p.a);
        }
    }

    private static class Node {
        int src;
        Set<Integer> adj;

        public Node(int src) {
            this.src = src;
            this.adj = new HashSet<>();
        }

        public void addEdge(int tgt) {
            adj.add(tgt);
        }
    }

    private static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;

            Pair p = (Pair) o;
            return this.a == p.a && this.b == p.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
