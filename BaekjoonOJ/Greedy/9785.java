import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] arr = new Pair[read()];
        int m = read();
        for (int i = 0; i < arr.length; i++) arr[i] = new Pair(read(), read());

        Arrays.sort(arr);

        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            sum += arr[i].a;
            min = Math.min(min, arr[i].b);
        }

        bw.write(sum + " " + min);
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return o.a != this.a ? o.a - this.a : o.b - this.b;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
