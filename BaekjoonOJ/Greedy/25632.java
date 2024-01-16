import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static boolean[] nonPrime = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieve();

        Set<Integer> A = new HashSet<>(), B = new HashSet<>();
        int a = read(), b = read(), c = read(), d = read(), cnt = 0;

        for (int i = a; i <= b; i++) if (!nonPrime[i]) A.add(i);

        for (int i = c; i <= d; i++) {
            if (!nonPrime[i]) {
                B.add(i);
                if (A.contains(i)) cnt++;
            }
        }

        bw.write(A.size() == B.size() ? (cnt % 2 == 0 ? "yj" : "yt") : (A.size() < B.size() ? "yj" : "yt"));
        bw.flush();
    }

    private static void sieve() {
        double sqrt = Math.sqrt(nonPrime.length);

        for (int i = 2; i < sqrt; i++) {
            if (nonPrime[i]) continue;
            for (int j = i * i; j < nonPrime.length; j += i) nonPrime[j] = true;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
