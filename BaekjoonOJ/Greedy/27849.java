import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = read(), t = read(), prev = 0, rem = 0, cnt = 0;
        while (n-- > 0) {
            long d = read(), b = read(), req = d - prev;

            if (rem > req) {
                cnt += req;
                rem -= req;
            } else {
                cnt += rem;
                rem = 0;
            }

            rem += b;
            prev = d;
        }

        bw.write(String.valueOf(cnt + Math.min(rem, t - prev + 1)));
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
