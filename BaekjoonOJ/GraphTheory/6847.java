import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static Node[] graph = new Node[10000];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), u, v, cnt;
        while (n-- > 0) graph[u = read()] = new Node(u, read());

        while ((u = read()) != 0 && (v = read()) != 0)
            sb.append((cnt = bfs(u, v)) == -1 ? "No" : "Yes " + cnt).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int bfs(int src, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visit = new boolean[10000];
        q.offer(src);
        visit[src] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            for (int tgt : graph[q.poll()].adj) {
                if (visit[tgt]) continue;
                if (tgt == dest) return cnt;

                q.offer(tgt);
                visit[tgt] = true;
                cnt++;
            }
        }

        return -1;
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src, int tgt) {
            this.src = src;
            adj = new ArrayList<>();
            adj.add(tgt);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
