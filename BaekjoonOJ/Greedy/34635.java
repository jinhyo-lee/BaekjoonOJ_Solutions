import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = read(), g = read(), b = read();

        bw.write(String.valueOf(calc(Math.max(0, r - read()), Math.max(0, g - read()), Math.max(0, b - read()), read(), read())));
        bw.flush();
    }

    private static int calc(int r, int g, int b, int rg, int gb) {
        if ((r > rg || b > gb) || g > rg - r + gb - b) return -1;

        return r + g + b;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
