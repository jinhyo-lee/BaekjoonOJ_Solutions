import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read(), max = n;
        while (k > 2) max = Math.max(max, reverse(n * k--));

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int reverse(int src) {
        int tgt = 0;
        do tgt = tgt * 10 + src % 10; while ((src /= 10) > 0);

        return tgt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
