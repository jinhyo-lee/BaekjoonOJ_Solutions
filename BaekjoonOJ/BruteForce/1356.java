import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int len = String.valueOf(n).length();

        boolean flag = false;
        for (int i = 1; i < len && !flag; i++) flag = check(n, i);

        bw.write(flag ? "YES" : "NO");
        bw.flush();
    }

    private static boolean check(int n, int div) {
        int a = 1;
        while (div-- > 0) {
            a *= n % 10;
            n /= 10;
        }

        int b = 1;
        while (n > 0) {
            b *= n % 10;
            n /= 10;
        }

        return a == b;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
