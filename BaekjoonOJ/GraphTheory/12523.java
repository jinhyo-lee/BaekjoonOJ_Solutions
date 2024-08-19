import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int cnt;
    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int n = read() + 1;
            graph = new Node[n];
            for (int i = 1; i < n; i++) graph[i] = new Node(n);
            for (int i = 1; i < n; i++) graph[read()].adj.add(i);

            sb.append("Case #").append(tc).append(":\n");
            for (int i = 1; i < n; dfs(i++), sb.append(cnt).append("\n"), cnt = 0) visit = new boolean[n];
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int src) {
        visit[src] = true;
        cnt++;
        for (int tgt : graph[src].adj) if (!visit[tgt]) dfs(tgt);
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
