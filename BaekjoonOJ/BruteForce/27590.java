import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ds = read(), ys = read(), dm = read(), ym = read(), s = ys - ds, m = ym - dm;
        while (s != m) {
            if (s < m) s += ys;
            else m += ym;
        }

        bw.write(String.valueOf(s));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
