import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        do if (contains(n)) break; while (n-- > 4);

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static boolean contains(int n) {
        int m;
        do if ((m = n % 10) != 4 && m != 7) return false; while ((n /= 10) > 0);

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
