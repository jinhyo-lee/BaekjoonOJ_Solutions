import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Long> pq = new PriorityQueue<>();
        int n = read(), m = read(), k = read();
        while (m-- > 0) pq.add(0L);
        while (n-- > 0) pq.add(pq.remove() + read());

        bw.write(pq.remove() > k ? "GO" : "WAIT");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
