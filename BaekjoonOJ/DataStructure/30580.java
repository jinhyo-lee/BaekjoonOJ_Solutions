import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long c = read();
        long[] arr = new long[(int) read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        for (long i : arr) {
            if (i * (c / i) != c) continue;
            bw.write(concat(i, c / i));
            break;
        }

        bw.flush();
    }

    private static String concat(long i, long j) {
        return Math.min(i, j) + " " + Math.max(i, j);
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
