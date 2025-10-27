import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] arr = new Pair[read()];
        int l = read(), k = read();
        for (int i = 0; i < arr.length; i++) arr[i] = new Pair(read(), read());
        Arrays.sort(arr);

        int sum = 0;
        for (Pair p : arr) {
            if (k-- == 0) break;
            if (p.b <= l) sum += 140;
            else if (p.a <= l) sum += 100;
            else k++;
        }

        bw.write(String.valueOf(sum));
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
            return this.b != o.b ? this.b - o.b : this.a - o.a;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
