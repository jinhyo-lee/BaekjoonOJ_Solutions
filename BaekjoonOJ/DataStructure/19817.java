import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), max = 0;
        Data[] arr = new Data[n];
        while (n-- > 0) {
            arr[n] = new Data();
            int m = read();
            while (m-- > 0) max = Math.max(max, arr[n].offer(read()));
        }

        long sum = 0;
        for (Data data : arr) sum += (long) (max - data.peek()) * data.pq.size();

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static class Data {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        public int offer(int i) {
            pq.offer(i);
            return i;
        }

        public int peek() {
            return pq.peek() != null ? pq.peek() : 0;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
