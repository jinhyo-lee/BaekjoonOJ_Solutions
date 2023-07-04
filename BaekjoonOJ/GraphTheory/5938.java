import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Node[n];
        for (int i = 0; i < n; i++)
            graph[i] = new Node(i);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph[u].addEdge(v);
            graph[v].addEdge(u);
        }

        visit = new boolean[n];
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (!visit[i]) sb.append(i + 1).append("\n");

        bw.write(sb.length() > 0 ? sb.toString() : "0");
        bw.flush();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {
            for (int tgt : graph[q.poll()].adj) {
                if (!visit[tgt]) {
                    q.offer(tgt);
                    visit[tgt] = true;
                }
            }
        }
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
