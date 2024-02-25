import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read(), b = read(), n = read(), w = read(), m = -1;
        for (int i = 1; i < n; i++) {
            if (i * a + (n - i) * b == w) {
                if (m != -1) {
                    m = -1;
                    break;
                } else m = i;
            }
        }

        bw.write(m != -1 ? m + " " + (n - m) : "-1");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
