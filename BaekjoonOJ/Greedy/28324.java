import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = (int) read();

        long[] arr = new long[n];
        while (n-- > 0) arr[n] = read();

        long sum = arr[0] = 1;
        for (int i = 1; i < arr.length; i++) sum += arr[i] = Math.min(arr[i], arr[i - 1] + 1);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
