import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] x = new int[n], y = new int[n];

        for (int i = 0; i < n; i++) x[i] = read();
        for (int i = 0; i < n; i++) y[i] = read();

        Arrays.sort(x);
        Arrays.sort(y);

        boolean flag = true;
        while (n-- > 0) {
            if (x[n] > y[n]) {
                flag = false;
                break;
            }
        }

        bw.write(flag ? "DA" : "NE");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
