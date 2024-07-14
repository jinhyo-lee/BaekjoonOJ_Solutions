import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Pair[] arr = new Pair[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = new Pair(i, read(), read());

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < 3; sum += arr[i++].p) sb.append(arr[i].i + 1).append("\n");
        sb.insert(0, sum + "\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int i, p;
        double r;

        Pair(int i, int j, int p) {
            this.i = i;
            this.r = (double) j / p;
            this.p = p;
        }

        @Override
        public int compareTo(Pair o) {
            double r = o.r - this.r;
            return r < 0 ? -1 : r > 0 ? 1 : 0;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
