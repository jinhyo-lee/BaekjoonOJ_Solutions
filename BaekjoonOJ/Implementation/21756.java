import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new ArrayDeque<>();
        int n = read();
        for (int i = 1; i <= n; i++) q.offer(i);

        while ((n = q.size()) > 1) {
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) q.poll();
                else q.offer(q.poll());
            }
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
