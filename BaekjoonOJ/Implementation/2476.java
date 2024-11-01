import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), max = 0;
        while (n-- > 0) {
            int a = read(), b = read(), c = read(), i;
            if (a == b && b == c) i = 10000 + 1000 * a;
            else if (a == b || b == c) i = 1000 + 100 * b;
            else if (a == c) i = 1000 + 100 * a;
            else i = Math.max(a, Math.max(b, c)) * 100;
            max = Math.max(max, i);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
