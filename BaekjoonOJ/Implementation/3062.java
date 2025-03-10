import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read(), sum = n + reverse(n);
            sb.append(sum == reverse(sum) ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int reverse(int n) {
        int r = 0;
        do r = r * 10 + n % 10; while ((n /= 10) > 0);

        return r;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
