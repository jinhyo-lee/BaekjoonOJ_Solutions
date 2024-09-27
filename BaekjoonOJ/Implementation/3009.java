import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y1 = read(), x1 = read(), y2 = read(), x2 = read(), y3 = read(), x3 = read();

        bw.write((y1 == y2 ? y3 : y1 == y3 ? y2 : y1) + " " + (x1 == x2 ? x3 : x1 == x3 ? x2 : x1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
