import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        Pair[] arr = new Pair[m];
        for (int i = 0; i < m; i++) arr[i] = new Pair(read(), read());

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.b - o1.b;
            }
        });

        int cnt = 0;
        while (m-- > 1) if (arr[m].b > n) cnt += n - arr[m].a;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
