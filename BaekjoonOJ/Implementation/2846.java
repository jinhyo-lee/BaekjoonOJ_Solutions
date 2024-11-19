import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), i = read(), j = i, k = 0, max = 0;
        while (n-- > 1) {
            if ((k = read()) <= j) {
                max = Math.max(max, j - i);
                i = k;
            }
            j = k;
        }

        bw.write(String.valueOf(Math.max(max, k - i)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
