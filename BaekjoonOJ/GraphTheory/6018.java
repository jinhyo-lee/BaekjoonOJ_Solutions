import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read(), q = read();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        while (m-- > 0) union(read(), read());

        while (q-- > 0) sb.append(find(read()) == find(read()) ? "Y\n" : "N\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[b] = a;
    }

    private static int find(int node) {
        if (node == parent[node]) return node;

        return parent[node] = find(parent[node]);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
