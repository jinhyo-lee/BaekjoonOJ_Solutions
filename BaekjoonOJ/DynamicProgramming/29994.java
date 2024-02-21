import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[][] cache = new int[2][n + 1];

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (read() == 1) {
                cache[1][i] = cache[0][i - 1] + 1;
                cache[0][i] = cache[1][i - 1];
            } else {
                cache[0][i] = cache[0][i - 1] + 1;
                cache[1][i] = cache[1][i - 1];
            }
            sum += cache[1][i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
