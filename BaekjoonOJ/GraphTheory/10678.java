import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, idx;
    static Node[] graph;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Node[n];
        for (int i = 0; i < n; i++)
            graph[i] = new Node(i);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].addEdge(new Target(v, new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}));
        }

        n--;
        list = new ArrayList<>();
        dfs(0, 0);
        Set<Integer> set = new HashSet<>(list);

        idx++;
        list = new ArrayList<>();
        dfs(0, 0);
        set.retainAll(list);

        String res;
        if (!set.isEmpty()) res = String.valueOf(Collections.min(set));
        else res = "IMPOSSIBLE";

        bw.write(res);
        bw.flush();
    }

    private static void dfs(int node, int sum) {
        if (node == n) {
            list.add(sum);
            return;
        }

        for (Target tgt : graph[node].adj)
            dfs(tgt.node, sum + tgt.weight[idx]);
    }

    private static class Node {
        int src;
        List<Target> adj;

        public Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }

        public void addEdge(Target tgt) {
            adj.add(tgt);
        }
    }

    private static class Target {
        int node;
        int[] weight;

        public Target(int node, int[] weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
