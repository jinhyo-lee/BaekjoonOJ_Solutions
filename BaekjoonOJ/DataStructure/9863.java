import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new ArrayDeque<>();
        int n;
        while ((n = read()) != 0) {
            for (int i = 1; i <= n; i++) q.offer(i);

            int m = read(), k = read();
            while (k-- > 0) {
                for (int i = 1; i < m; i++) q.offer(q.poll());
                if (k > 0) q.poll();
            }

            sb.append(q.poll()).append("\n");
            q.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
