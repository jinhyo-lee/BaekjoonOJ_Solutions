import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();

        Pair[] arr = new Pair[n];
        Set<Integer> set = new TreeSet<>();
        while (n-- > 0) set.add((arr[n] = new Pair(read(), read())).in);

        int max = 0, res = 0;
        for (int in : set) {
            int sum = 0;
            for (Pair p : arr) if (in <= p.in && in > p.out) sum += in - p.out;

            if (max < sum) {
                max = sum;
                res = in;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static class Pair {
        int in, out;

        Pair(int in, int out) {
            this.in = in;
            this.out = out;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
