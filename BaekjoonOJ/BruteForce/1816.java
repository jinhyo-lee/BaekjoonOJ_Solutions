import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] nonPrime;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sieve();

        int n = (int) read();
        while (n-- > 0) sb.append(isProper(read()) ? "YES\n" : "NO\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void sieve() {
        nonPrime = new boolean[1000001];
        double sqrt = Math.sqrt(nonPrime.length);

        for (int i = 2; i < sqrt; i++) {
            if (nonPrime[i]) continue;
            for (int j = i * i; j < nonPrime.length; j += i) nonPrime[j] = true;
        }
    }

    private static boolean isProper(long s) {
        for (int i = 2; i < nonPrime.length; i++)
            if (!nonPrime[i] && s % i == 0) return false;

        return true;
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
