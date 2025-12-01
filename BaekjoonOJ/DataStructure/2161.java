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
        int n = read();
        for (int i = 1; i <= n; i++) q.offer(i);

        while (q.size() > 1) {
            sb.append(q.poll()).append(' ');
            q.offer(q.poll());
        }

        bw.write(sb.append(q.poll()).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
