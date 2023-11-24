import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), i = 0, len = 0;
        do len += calcLen(++i); while (len < n);

        len -= n;
        while (len-- > 0) i /= 10;

        bw.write(String.valueOf(i % 10));
        bw.flush();
    }

    private static int calcLen(int i) {
        int len = 0;
        do len++; while ((i /= 10) > 0);

        return len;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
