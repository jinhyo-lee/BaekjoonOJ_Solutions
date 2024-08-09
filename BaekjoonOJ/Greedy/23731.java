import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double n = round(read()), m = 1;
        while (m < n) n = round(n / (m *= 10)) * m;

        bw.write(String.valueOf(Math.round(n)));
        bw.flush();
    }

    private static double round(double n) {
        return n % 1 < 0.5 ? n : Math.round(n);
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
