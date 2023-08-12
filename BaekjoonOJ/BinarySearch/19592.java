import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, x, y;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = read();
            x = read();
            y = read();

            int max = 0;
            for (int i = 0; i < n - 1; i++)
                max = Math.max(max, read());

            if (max < (n = read())) sb.append("0\n");
            else sb.append(binarySearch((double) x / max)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(double key) {
        int low = 1, high = y;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (1.0 + (double) (x - mid) / n < key) high = mid - 1;
            else low = mid + 1;
        }

        return low > y ? -1 : low;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
