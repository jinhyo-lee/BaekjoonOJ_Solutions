import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(count(read())));
        bw.flush();
    }

    private static int count(int n) {
        int cnt = n / 5;
        n %= 5;

        do {
            if (n % 2 == 0) return n / 2 + cnt;
            n += 5;
        } while (cnt-- > 0);

        return -1;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
