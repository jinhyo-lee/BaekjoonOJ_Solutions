import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();

        long low = n, high = n * 2L;
        while (low <= high) {
            long mid = (low + high) / 2;

            if (n > mid - (mid / 3 + mid / 5 - mid / 15)) low = mid + 1;
            else high = mid - 1;
        }

        bw.write(String.valueOf(low));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
