import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read(), m = read();

            a = new int[n];
            for (int i = 0; i < n; i++) a[i] = read();

            b = new int[m];
            for (int i = 0; i < m; i++) b[i] = read();

            Arrays.sort(b);

            long sum = 0;
            for (int i = 0; i < n; i++) sum += binarySearch(a[i]);

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int key) {
        int low = 0, high = b.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (b[mid] < key) low = mid + 1;
            else high = mid - 1;
        }

        if (low == b.length) return b[b.length - 1];
        if (high < 0) return b[0];

        return Math.abs(key - b[low]) < Math.abs(key - b[high]) ? b[low] : b[high];
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
