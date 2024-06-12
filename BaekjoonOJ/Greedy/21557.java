import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() - 2, a = read(), b;
        for (int i = 0; i < n; i++) read();
        b = read();

        while (n-- > 1) {
            if (a > b) a--;
            else b--;
        }

        bw.write(String.valueOf(Math.max(a, b) - 1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
