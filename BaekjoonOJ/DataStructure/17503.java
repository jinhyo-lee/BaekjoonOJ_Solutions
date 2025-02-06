import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();
        Pair[] arr = new Pair[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = new Pair(read(), read());
        Arrays.sort(arr);

        bw.write(String.valueOf(getMin(n, m, arr)));
        bw.flush();
    }

    private static int getMin(int n, int m, Pair[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (Pair p : arr) {
            pq.add(p.v);
            sum += p.v;

            if (pq.size() > n) sum -= pq.remove();
            if (pq.size() == n && sum >= m) return p.c;
        }

        return -1;
    }

    private static class Pair implements Comparable<Pair> {
        int v, c;

        Pair(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return this.c - o.c;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
