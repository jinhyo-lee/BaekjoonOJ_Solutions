import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge>[] tree;
    static boolean[] visit;
    static int maxDist = 0;
    static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());
        tree = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());

            int dest;
            while (!((dest = Integer.parseInt(st.nextToken())) == -1)) {
                int weight = Integer.parseInt(st.nextToken());
                tree[src].add((new Edge(dest, weight)));
            }
        }

        visit = new boolean[v + 1];
        dfs(1, 0);

        visit = new boolean[v + 1];
        dfs(maxNode, 0);

        bw.write(maxDist + "\n");
        bw.flush();
    }

    private static void dfs(int node, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            maxNode = node;
        }

        visit[node] = true;

        for (Edge dest : tree[node]) {
            if (!visit[dest.node]) {
                dfs(dest.node, dest.weight + dist);
                visit[dest.node] = true;
            }
        }
    }

    private static class Edge {
        int node, weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
