import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long t = read();
        while (t-- > 0) {
            skip();
            long[] arr = {read(), read(), read()};
            long n = arr[0] + arr[1] + arr[2] - read(), m, k;

            Arrays.sort(arr);

            n -= m = Math.min(n / 3, arr[0]);
            k = Math.min(n / 2, arr[1]);

            sb.append(m * k * (n - k)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

    private static void skip() throws IOException {
        while (true) if (System.in.read() == '\n') break;
    }

}
