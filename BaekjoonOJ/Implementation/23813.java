import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int k;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = n;
        k = pow(String.valueOf(n).length());
        long sum = 0;
        do sum += m = rotate(m); while (n != m);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int rotate(int n) {
        return n % 10 * k + n / 10;
    }

    private static int pow(int i) {
        int n = 1;
        while (--i > 0) n *= 10;

        return n;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
