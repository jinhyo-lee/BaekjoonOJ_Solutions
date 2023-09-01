import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = read(), y = read(), a = read(), b = read();

        int n = -1, i = 0;
        while (i++ < 198) {
            if (a == b) {
                n = a;
                break;
            }

            if (a < b) a += x;
            else b += y;
        }

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
