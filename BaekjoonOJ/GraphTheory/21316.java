import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node[] graph = new Node[13];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 12; i++) graph[i] = new Node(i);

        for (int i = 0; i < 12; i++) {
            int u = read(), v = read();
            graph[u].addEdge(v);
            graph[v].addEdge(u);
        }

        bw.write(String.valueOf(findSpica()));
        bw.flush();
    }

    private static int findSpica() {
        for (int i = 1; i <= 12; i++) {
            Node node = graph[i];
            if (node.adj.size() == 3) {
                boolean a = false, b = false, c = false;
                for (int src : node.adj) {
                    if (graph[src].adj.size() == 1) a = true;
                    else if (graph[src].adj.size() == 2) b = true;
                    else if (graph[src].adj.size() == 3) c = true;
                }
                if (a && b && c) return node.src;
            }
        }

        return -1;
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
