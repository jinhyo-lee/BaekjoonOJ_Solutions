import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read(), b = read(), c = read(), d = read(), e = read(), cnt = c + d + e;

        a -= d;
        if (b < c) a -= (c - b) * 2;
        else if ((b -= c) > 0) {
            cnt += b / 2;
            a -= b / 2;
            if (b % 2 == 1) {
                cnt++;
                a -= 3;
            }
        }

        if (a > 0) cnt += (a + 4) / 5;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
