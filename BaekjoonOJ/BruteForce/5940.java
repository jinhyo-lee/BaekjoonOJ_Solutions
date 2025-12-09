import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read(), b = read();
        while (a++ < 63) if (calc(a, b)) break;

        bw.write(a < 63 ? String.valueOf(a) : "0");
        bw.flush();
    }

    private static boolean calc(int a, int b) {
        long n = (long) Math.pow(2, a);
        do n /= 10; while (n > 10);

        return n == b;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
