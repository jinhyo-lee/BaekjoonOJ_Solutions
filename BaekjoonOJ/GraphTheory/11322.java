import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read(), n;
        while (t-- > 0) sb.append((n = read()) == 1 ? 1 : bfs(n)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static long bfs(int n) {
        Queue<Long> q = new ArrayDeque<>();
        q.offer(1L);

        while (!q.isEmpty()) {
            long x = q.poll() * 10;

            if (x % n == 0) return x;
            q.offer(x);

            if (++x % n == 0) return x;
            q.offer(x);
        }

        return -1;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
