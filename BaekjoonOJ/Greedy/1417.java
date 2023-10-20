import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), a = read();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 1) pq.offer(read());

        int cnt = 0;
        while (!pq.isEmpty() && a <= pq.peek()) {
            pq.offer(pq.poll() - 1);
            a++;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
