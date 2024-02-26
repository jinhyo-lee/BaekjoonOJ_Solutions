import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read(), sum = divisors(n);

            if (sum == n) sb.append("Perfect\n");
            else if (sum < n) sb.append("Deficient\n");
            else sb.append("Abundant\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int divisors(int n) {
        double sqrt = Math.sqrt(n);
        int sum = 0;
        for (int i = 1; i <= sqrt; i++) if (n % i == 0) sum += n / i != i ? i + n / i : i;

        return sum - n;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
