import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int m, n;
        while ((m = read()) != 0) {
            n = read();
            int x = 0, y = 0;
            for (int i = m; i <= n; i++) {
                int k = 0;
                for (int j = 1; j <= i; j++) if (i % j == 0) k++;
                if (x < i && y <= k) {
                    x = i;
                    y = k;
                }
            }
            sb.append(x).append(' ').append(y).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
