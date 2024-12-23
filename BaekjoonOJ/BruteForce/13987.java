import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[6], b = new int[6];
        for (int i = 0; i < 6; i++) a[i] = read();
        for (int i = 0; i < 6; i++) b[i] = read();

        int p = 0, q = 0;
        for (int i : a) {
            for (int j : b) {
                if (i > j) p++;
                else if (i == j) q++;
            }
        }

        bw.write(String.format("%.5f", (double) p / (36 - q)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
