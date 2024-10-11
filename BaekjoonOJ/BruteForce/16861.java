import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        while (n % calc(n) != 0) n++;

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static int calc(int n) {
        int sum = 0;
        do sum += n % 10; while ((n /= 10) > 0);

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
