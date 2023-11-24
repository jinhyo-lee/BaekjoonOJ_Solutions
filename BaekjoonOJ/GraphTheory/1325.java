import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node[] graph;
    static boolean[] visit;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read();

        graph = new Node[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new Node(i);
        for (int i = 0; i < m; i++) graph[read()].addEdge(read());

        cnt = new int[n + 1];
        for (int i = 1; i <= n; dfs(i++)) visit = new boolean[n + 1];

        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, cnt[i]);
        for (int i = 1; i <= n; i++) if (cnt[i] == max) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int src) {
        visit[src] = true;
        for (int tgt : graph[src].adj) {
            if (!visit[tgt]) {
                cnt[tgt]++;
                dfs(tgt);
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
