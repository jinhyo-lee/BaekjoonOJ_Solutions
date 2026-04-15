import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read(), b = read(), c = read(), d = read();
        while (b > 0 && d > 0) {
            b -= c;
            d -= a;
        }

        bw.write(b <= 0 && d <= 0 ? "DRAW" : b <= 0 ? "PLAYER B" : "PLAYER A");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
