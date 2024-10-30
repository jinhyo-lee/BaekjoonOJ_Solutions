import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = read(), m = read(), t = 0;
        while (++t < m) if (-6 * Math.pow(t, 4) + h * Math.pow(t, 3) + 2 * Math.pow(t, 2) + t <= 0) break;

        bw.write(t == m ? "The balloon does not touch ground in the given time." : "The balloon first touches ground at hour: " + t);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
