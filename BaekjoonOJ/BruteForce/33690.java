import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        for (int i = 1; i < 10; i++) count(i);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void count(int i) {
        long l = i;
        while (l <= n) {
            l = l * 10 + i;
            cnt++;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
