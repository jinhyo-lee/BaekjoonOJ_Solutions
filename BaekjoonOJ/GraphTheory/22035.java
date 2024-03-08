import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        bw.write(m < n - 1 ? "-1" : connect(n, m));
        bw.flush();
    }

    private static String connect(int n, int m) {
        List<Edge> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) list.add(new Edge(1, i));
        for (int i = 2; i < n; i++) list.add(new Edge(i, n));

        return list.size() < m ? "-1" : extract(list, m);
    }

    private static String extract(List<Edge> list, int m) {
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) sb.append(list.get(m).extract()).append("\n");
        return sb.toString();
    }

    private static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        String extract() {
            return u + " " + v;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
