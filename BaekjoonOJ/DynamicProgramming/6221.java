import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        Pair[] arr = new Pair[n];
        int[] cache = new int[n];

        for (int i = 0; i < n; cache[i++] = 1) arr[i] = new Pair(read(), read());
        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < n; max = Math.max(max, cache[i++]))
            for (int j = 0; j < i; j++)
                if (arr[i].b > arr[j].b) cache[i] = Math.max(cache[i], cache[j] + 1);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int w, b;

        Pair(int w, int b) {
            this.w = w;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
