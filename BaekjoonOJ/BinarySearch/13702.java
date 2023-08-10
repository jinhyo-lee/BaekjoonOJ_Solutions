import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read();

        int[] arr = new int[n];
        while (n-- > 0) arr[n] = read();

        long low = 1, high = Integer.MAX_VALUE;
        while (low <= high) {
            long mid = (low + high) / 2;

            long sum = 0;
            for (int i : arr) sum += i / mid;

            if (sum < k) high = mid - 1;
            else low = mid + 1;
        }

        bw.write(String.valueOf(high));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
