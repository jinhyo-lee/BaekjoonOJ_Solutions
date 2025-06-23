import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = read(), m = read(), k = read(), cnt = 0;
        while (n-- > 0 && m >= 0) {
            int i = read();
            pq.offer(-i);
            m -= i;
            cnt++;

            if (m < 0 && k > 0 && !pq.isEmpty()) {
                m -= pq.poll();
                k--;
            }
        }

        bw.write(String.valueOf(cnt - (m < 0 ? 1 : 0)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
