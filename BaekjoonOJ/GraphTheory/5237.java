import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

            graph = new Node[n];
            visit = new boolean[n];
            while (n-- > 0) graph[n] = new Node(n);

            while (k-- > 0) addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            dfs(0);

            sb.append(isConnected());
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int src) {
        visit[src] = true;

        for (int tgt : graph[src].adj) if (!visit[tgt]) dfs(tgt);
    }

    private static String isConnected() {
        for (boolean flag : visit) if (!flag) return "Not connected.\n";

        return "Connected.\n";
    }

    private static void addEdge(int u, int v) {
        graph[u].adj.add(v);
        graph[v].adj.add(u);
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }
    }

}
