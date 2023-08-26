import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();

        while (t-- > 0) {
            int n = read(), m = read() + 1, cnt = 0;

            while (n < m) cnt += contains(n++);

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int contains(int n) {
        int cnt = 0;
        do if (n % 10 == 0) cnt++; while ((n /= 10) > 0);

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
