import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node[] tree;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        tree = new Node[n];
        level = new int[n];

        for (int i = 0; i < n; i++) tree[i] = new Node(i);

        int root = 0, node;
        for (int i = 0; i < n; i++) {
            if ((node = read() - 1) == 130) root = i;
            else tree[node].addEdge(i);
        }

        dfs(root);

        for (int i : level) sb.append(i).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int src) {
        for (int tgt : tree[src].adj) {
            level[tgt] = level[src] + 1;
            dfs(tgt);
        }
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
