import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() + 1, m = read(), k = read();
        Node[] graph = new Node[n];
        boolean[] visit = new boolean[n];

        int[] arr = new int[m];
        while (m-- > 0) arr[m] = read();

        while (n-- > 1) graph[n] = new Node(n);
        while (k-- > 0) {
            int u = read(), v = read();
            graph[u].adj.add(v);
            graph[v].adj.add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i : arr) {
            if (visit[i]) continue;

            q.offer(i);
            visit[i] = true;
            cnt++;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int tgt : graph[cur].adj) {
                    if (visit[tgt]) continue;

                    q.offer(tgt);
                    visit[tgt] = true;
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            adj = new ArrayList<>();
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
