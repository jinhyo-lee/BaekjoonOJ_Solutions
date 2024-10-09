import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = read(), d = read(), x = read();
        do if (sum(l) == x) break; while (l++ < d);
        do if (sum(d) == x) break; while (d-- > l);

        bw.write(l + "\n" + d);
        bw.flush();
    }

    private static int sum(int i) {
        int sum = 0;
        do sum += i % 10; while ((i /= 10) > 0);

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
