import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] nonPrime = new boolean[119];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sieve();

        int n = read();
        while (n-- > 0) sb.append(isPossible(read()));

        bw.write(sb.toString());
        bw.flush();
    }

    private static String isPossible(int a) {
        for (int i = 2; i < a; i++) if (!nonPrime[i] && !nonPrime[a - i]) return "Yes\n";

        return "No\n";
    }

    private static void sieve() {
        nonPrime[0] = nonPrime[1] = true;

        double sqrt = Math.sqrt(nonPrime.length);
        for (int i = 2; i < sqrt; i++)
            if (!nonPrime[i]) for (int j = i * i; j < nonPrime.length; j += i) nonPrime[j] = true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
