import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = read(), n = read(), sum = 0, min = 0;
        for (int i = m; i <= n; i++) {
            if (isPerfectSquare(i)) {
                sum += i;
                if (min == 0) min = i;
            }
        }

        bw.write(min != 0 ? sum + "\n" + min : "-1");
        bw.flush();
    }

    private static boolean isPerfectSquare(int i) {
        int sqrt = (int) Math.sqrt(i);
        return sqrt * sqrt == i;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
