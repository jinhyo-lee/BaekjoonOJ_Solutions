import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) + 1, e = Integer.parseInt(st.nextToken());
            graph = new Node[n];
            visit = new int[n];

            while (n-- > 1) graph[n] = new Node(n);
            while (e-- > 0) {
                int u = parse(st.nextToken()), v = parse(st.nextToken());
                graph[u].adj.add(v);
                graph[v].adj.add(u);
            }

            int vx = parse(st.nextToken());
            bfs(vx);

            int cnt = 0;
            for (int i : visit) if (i > 1 && i < 4) cnt++;

            sb.append("The number of supervillains in 2-hop neighborhood of v").append(vx).append(" is ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s.substring(1));
    }

    private static void bfs(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        visit[root] = 1;

        while (!q.isEmpty()) {
            int src = q.poll();
            for (int tgt : graph[src].adj) {
                if (visit[tgt] == 0) {
                    q.offer(tgt);
                    visit[tgt] = visit[src] + 1;
                }
            }
        }
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            adj = new ArrayList<>();
        }
    }

}
