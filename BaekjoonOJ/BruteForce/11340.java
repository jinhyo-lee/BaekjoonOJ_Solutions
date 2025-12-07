import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int a = read(), b = read(), c = read(), d = 0;
            while (calc(a, b, c, d) < 9000) d++;
            sb.append(d < 101 ? d : "impossible").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int a, int b, int c, int d) {
        return a * 15 + b * 20 + c * 25 + d * 40;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
