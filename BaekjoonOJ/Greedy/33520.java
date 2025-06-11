import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), w = 0, h = 0;
        while (n-- > 0) {
            int a = read(), b = read();
            w = Math.max(w, Math.min(a, b));
            h = Math.max(h, Math.max(a, b));
        }

        bw.write(String.valueOf((long) w * h));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
