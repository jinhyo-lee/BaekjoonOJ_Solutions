import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), gcd = n == 2 ? gcd(read(), read()) : gcd(read(), gcd(read(), read()));

        for (int i = 1; i <= gcd / 2; i++) if (gcd % i == 0) sb.append(i).append("\n");

        bw.write(sb.append(gcd).toString());
        bw.flush();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
