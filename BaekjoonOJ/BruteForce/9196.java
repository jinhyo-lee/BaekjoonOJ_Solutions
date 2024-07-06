import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Pair> pq = new PriorityQueue<>();
        int h, w, d, o;
        while ((h = read()) != 0) {
            w = read();
            d = calc(h, w);

            for (int i = 1; i < 151; i++)
                for (int j = i + 1; j < 151; j++)
                    if ((o = calc(i, j)) > d || (o == d && i > h)) pq.offer(new Pair(i, j));

            Pair p = pq.poll();
            assert p != null;
            sb.append(p.h).append(" ").append(p.w).append("\n");
            pq.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int h, w, d;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
            this.d = calc(h, w);
        }

        @Override
        public int compareTo(Pair o) {
            return this.d != o.d ? this.d - o.d : this.h - o.h;
        }
    }

    private static int calc(int h, int w) {
        return h * h + w * w;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
