import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        graph = new Node[++n];
        visit = new boolean[n];

        while (n-- > 1) graph[n] = new Node(n);

        while (m-- > 0) {
            n = read();
            graph[read()].addEdge(n);
        }

        bw.write(String.valueOf(dfs(read())));
        bw.flush();
    }

    private static int dfs(int src) {
        visit[src] = true;

        int cnt = 0;
        for (int tgt : graph[src].adj) if (!visit[tgt]) cnt += dfs(tgt) + 1;

        return cnt;
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

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
