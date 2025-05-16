import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] arr = new Pair[11];
        for (int i = 0; i < 11; i++) arr[i] = new Pair(read(), read());

        Arrays.sort(arr);

        int sum = 0, d = 0;
        for (Pair p : arr) sum += (d += p.d) + 20 * p.v;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int d, v;

        Pair(int d, int v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return d - o.d;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
