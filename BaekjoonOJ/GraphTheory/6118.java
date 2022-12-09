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

    static int n, m, num, maxDist, cnt;
    static List<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph[src].add(dest);
            graph[dest].add(src);
        }

        bfs();

        bw.write(num + " " + maxDist + " " + cnt);
        bw.flush();
    }

    private static void bfs() {
        Queue<Edge> q = new LinkedList<>();
        q.offer(new Edge(1, 0));

        visit = new boolean[n + 1];
        visit[1] = true;

        while (!q.isEmpty()) {
            Edge edge = q.poll();
            int src = edge.node;
            int dist = edge.weight;

            if (maxDist < dist) {
                maxDist = dist;
                num = src;
                cnt = 1;
            } else if (maxDist == dist) {
                if (num > src)
                    num = src;
                cnt++;
            }

            for (int dest : graph[src]) {
                if (visit[dest])
                    continue;

                q.offer(new Edge(dest, dist + 1));
                visit[dest] = true;
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
