import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read() + 1, m = read(), k = read();

            Node[] graph = new Node[n];
            while (n-- > 1) graph[n] = new Node(n);

            while (m-- > 0) {
                int a = read(), b = read();
                graph[a].adj.add(b);
                graph[b].adj.add(a);
            }

            Set<Integer> set = new HashSet<>();
            while (k-- > 0) {
                int v = read();
                set.add(v);
                set.addAll(graph[v].adj);
            }

            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            adj = new ArrayList<>();
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
