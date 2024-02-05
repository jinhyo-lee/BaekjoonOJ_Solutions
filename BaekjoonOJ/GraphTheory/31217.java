import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        Node[] graph = new Node[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new Node(i);

        while (m-- > 0) {
            graph[read()].adj++;
            graph[read()].adj++;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (graph[i].adj > 2) cnt = (cnt + graph[i].adj * (graph[i].adj - 1) * (graph[i].adj - 2) / 6) % 1000000007;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Node {
        int src, adj;

        Node(int src) {
            this.src = src;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
