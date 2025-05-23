import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), x = read(), j = read(), cnt = 1, max = 0;
        for (int i = 1; i < n; i++) {
            int k = read();
            if (k - j <= x) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
            j = k;
        }

        bw.write(String.valueOf(Math.max(max, cnt)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
