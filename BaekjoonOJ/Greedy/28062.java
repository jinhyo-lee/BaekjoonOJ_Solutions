import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), sum = 0, min = Integer.MAX_VALUE;
        while (n-- > 0) {
            int i = read();
            sum += i;
            if ((i & 1) == 1) min = Math.min(min, i);
        }

        bw.write(String.valueOf(sum - ((sum & 1) == 0 ? 0 : min)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
