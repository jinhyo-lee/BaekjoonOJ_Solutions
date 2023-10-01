import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = read();
        while (p-- > 0) {
            int n = read(), m = read(), a = 0, b = 1, cnt = 0;

            do {
                int tmp = (a + b) % m;
                a = b;
                b = tmp;
                cnt++;
            } while (a != 0 || b != 1);

            sb.append(n).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
