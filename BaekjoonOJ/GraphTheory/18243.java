import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Node[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new Node[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++)
            graph[i] = new Node(i);

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].addEdge(v);
            graph[v].addEdge(u);
        }

        bw.write(findSmallWorld() ? "Small World!" : "Big World!");
        bw.flush();
    }

    private static boolean findSmallWorld() {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, -1);
            bfs(i);

            if (!isSmallWorld())
                return false;
        }

        return true;
    }

    private static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(root);
        dist[root] = 0;

        while (!q.isEmpty()) {
            int src = q.poll();
            for (int tgt : graph[src].adj) {
                if (dist[tgt] == -1) {
                    dist[tgt] = dist[src] + 1;
                    q.offer(tgt);
                }
            }
        }
    }

    private static boolean isSmallWorld() {
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1 || dist[i] >= 7)
                return false;
        }

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
