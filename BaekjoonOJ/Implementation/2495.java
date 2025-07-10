import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            int n = read(), m = n % 10, cnt = 1, max = 0;
            while ((n /= 10) > 0) {
                int k = n % 10;
                if (m == k) cnt++;
                else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
                m = k;
            }
            bw.write(Math.max(max, cnt) + "\n");
        }

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
