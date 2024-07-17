import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() + 1, m = read();

        Node[] graph = new Node[n];
        while (n-- > 0) graph[n] = new Node(n);
        for (int i = 1; i < graph.length; i++) graph[read()].adj.add(i);

        Set<Integer> set = new HashSet<>();
        while (m-- > 0) set.add(read());

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        int cnt = 0, cur;
        while (!q.isEmpty()) {
            if (set.contains(cur = q.poll())) cnt++;
            else for (int tgt : graph[cur].adj) q.offer(tgt);
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
