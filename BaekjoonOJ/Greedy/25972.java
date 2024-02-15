import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        Pair[] arr = new Pair[n];
        while (n-- > 0) arr[n] = new Pair(read(), read());

        Arrays.sort(arr);

        int cnt = 1;
        for (int i = 0; i < arr.length - 1; i++) if (arr[i].a + arr[i].l < arr[i + 1].a) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int a, l;

        Pair(int a, int l) {
            this.a = a;
            this.l = l;
        }

        @Override
        public int compareTo(Pair o) {
            return a - o.a;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
