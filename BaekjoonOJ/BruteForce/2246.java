import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static Pair[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();

        arr = new Pair[n];
        for (int i = 0; i < n; i++) arr[i] = new Pair(read(), read());

        int cnt = 0;
        for (int i = 0; i < n; i++) if (compare(i)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean compare(int idx) {
        Pair tgt = arr[idx];
        for (int i = 0; i < arr.length; i++) {
            if (idx == i) continue;
            if (tgt.d >= arr[i].d && tgt.c >= arr[i].c) return false;
        }

        return true;
    }

    private static class Pair {
        int d, c;

        public Pair(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
