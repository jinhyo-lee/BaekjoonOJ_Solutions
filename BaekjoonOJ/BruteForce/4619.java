import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int b;
        while ((b = read()) != 0) {
            int n = read();
            double a = Math.pow(b, 1.0 / n);
            int l = (int) Math.floor(a), r = (int) Math.ceil(a);
            sb.append(b - Math.pow(l, n) < Math.pow(r, n) - b ? l : r).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
