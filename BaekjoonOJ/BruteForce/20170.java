import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] a = new int[6], b = new int[6];
        for (int i = 0; i < 6; i++) a[i] = read();
        for (int i = 0; i < 6; i++) b[i] = read();

        int cnt = 0;
        for (int i : a) for (int j : b) if (i > j) cnt++;

        int gcd = gcd(36, cnt);
        sb.append(cnt / gcd).append("/").append(36 / gcd);

        bw.write(sb.toString());
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
