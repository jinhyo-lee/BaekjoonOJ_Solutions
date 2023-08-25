import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = read(), cat;

        int cnt = 0;
        if (n > 0) {
            cat = cnt = 1;
            while (cat < n) {
                cat *= 2;
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
