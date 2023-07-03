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

        int n = Integer.parseInt(br.readLine());

        graph = new Node[n];
        for (int i = 0; i < n; i++)
            graph[i] = new Node(i);

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tgt = Integer.parseInt(st.nextToken()) - 1;
            graph[Integer.parseInt(st.nextToken()) - 1].addEdge(tgt);
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            dfs(i);
            if (isCentral()) {
                res = i + 1;
                break;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void dfs(int src) {
        visit[src] = true;

        for (int tgt : graph[src].adj)
            if (!visit[tgt]) dfs(tgt);
    }

    private static boolean isCentral() {
        for (boolean flag : visit) if (!flag) return false;

        return true;
    }

    private static class Node {
        int src;
        List<Integer> adj;

        public Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }

        public void addEdge(int tgt) {
            adj.add(tgt);
        }
    }

}
