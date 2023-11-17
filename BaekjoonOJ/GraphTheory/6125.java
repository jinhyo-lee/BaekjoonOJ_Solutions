import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    static int t;
    static Node[] tree;
    static boolean[] visit;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = read(), ns = read();
        t = read();

        tree = new Node[++p];
        visit = new boolean[p];
        while (p-- > 1) tree[p] = new Node(p);

        while (ns-- > 0) {
            int src = read();
            tree[src].addEdge(read());
            tree[src].addEdge(read());
        }

        dfs(1);

        sb.append(dq.size()).append("\n");
        while (!dq.isEmpty()) sb.append(dq.poll()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean dfs(int src) {
        visit[src] = true;
        dq.offer(src);

        if (src == t) return true;
        for (int i : tree[src].adj) if (!visit[i] && dfs(i)) return true;

        visit[src] = false;
        dq.pollLast();

        return false;
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
