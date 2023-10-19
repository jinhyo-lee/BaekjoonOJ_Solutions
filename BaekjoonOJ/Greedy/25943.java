import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() - 2, diff = read() - read();
        while (n-- > 0) {
            if (diff > 0) diff -= read();
            else diff += read();
        }

        diff = Math.abs(diff);

        int[] arr = {100, 50, 20, 10, 5, 2, 1};
        int cnt = 0;
        for (int i : arr) {
            if (i <= diff) {
                cnt += diff / i;
                diff %= i;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
