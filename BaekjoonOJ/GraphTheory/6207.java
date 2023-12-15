import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Node[] graph;
    static int[] cnt;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = read(), n = read(), m = read();

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) arr[i] = read() - 1;

        graph = new Node[n];
        for (int i = 0; i < n; i++) graph[i] = new Node(i);
        while (m-- > 0) graph[read() - 1].adj.add(read() - 1);

        cnt = new int[n];
        for (int i : arr) {
            visit = new boolean[n];
            dfs(i);
        }

        int res = 0;
        for (int i : cnt) if (i == k) res++;

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void dfs(int src) {
        if (visit[src]) return;

        visit[src] = true;
        cnt[src]++;

        for (int tgt : graph[src].adj) dfs(tgt);
    }

    private static class Node {
        int src;
        List<Integer> adj;

        Node(int src) {
            this.src = src;
            this.adj = new ArrayList<>();
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
