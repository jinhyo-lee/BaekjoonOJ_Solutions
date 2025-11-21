import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), i = (int) (Math.pow(10, String.valueOf(n).length()) - 1) / 9;

        bw.write(String.valueOf(count(n, i)));
        bw.flush();
    }

    private static int count(int n, int i) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / i;
            n %= i;
            i /= 10;
        }

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
