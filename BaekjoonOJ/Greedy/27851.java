import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = read(), k = read();
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) arr[i] = read();

        long sum = n + k;
        for (int i = 1; i < n; i++) sum += Math.min(arr[i] - arr[i - 1] - 1, k);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
