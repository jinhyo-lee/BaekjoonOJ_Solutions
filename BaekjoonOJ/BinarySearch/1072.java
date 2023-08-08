import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = read(), y = read();
        long z = y * 100L / x;

        if (z < 99) {
            int low = 1, high = x;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (z < 100L * (y + mid) / (x + mid)) high = mid - 1;
                else low = mid + 1;
            }

            bw.write(String.valueOf(low));
        } else bw.write("-1");

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
