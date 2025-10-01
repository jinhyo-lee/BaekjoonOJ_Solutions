import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        calc(read());

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void calc(int n) {
        if (n < 10) return;
        cnt++;

        int i = 1;
        do i *= (n % 10); while ((n /= 10) > 0);

        calc(i);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
