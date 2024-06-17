import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static Map<String, Integer> map = new HashMap<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new Node[n];
        visit = new boolean[n];

        while (n-- > 0) {
            graph[n] = new Node(n);
            map.put(br.readLine(), n);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String u = st.nextToken(), v = st.nextToken();
            graph[map.get(u)].adj.add(v);
            graph[map.get(v)].adj.add(u);
        }

        int cnt = 0;
        for (Node node : graph) {
            if (visit[node.src]) continue;
            dfs(node.src);
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int src) {
        visit[src] = true;
        for (String tgt : graph[src].adj) if (!visit[map.get(tgt)]) dfs(map.get(tgt));
    }

    private static class Node {
        int src;
        List<String> adj;

        Node(int src) {
            this.src = src;
            adj = new ArrayList<>();
        }
    }

}
