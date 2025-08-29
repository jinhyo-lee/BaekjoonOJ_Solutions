import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), a = 0, sum = 0;
        while (n-- > 0) {
            int b = read();
            if (a == b) break;
            sum += (b - a) / 2 + 1;
            a = b + 1;
        }

        bw.write(n == -1 ? String.valueOf(sum) : "-1");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
