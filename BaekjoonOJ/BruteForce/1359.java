import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read(), k = read();

        double c = 0, p = comb(n, m);

        while (k <= m) {
            if (n - m >= m - k) c += comb(m, k) * comb(n - m, m - k);
            k++;
        }

        bw.write(String.valueOf(c / p));
        bw.flush();
    }

    private static long comb(int n, int r) {
        if (n == r || r == 0) return 1;

        return comb(n - 1, r - 1) + comb(n - 1, r);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
