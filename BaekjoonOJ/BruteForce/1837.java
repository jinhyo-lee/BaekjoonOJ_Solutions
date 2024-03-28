import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static boolean[] nonPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieve();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = verify(new BigInteger(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(n == -1 ? "GOOD" : "BAD " + n);
        bw.flush();
    }

    private static int verify(BigInteger p, int k) {
        for (int i = 2; i < k; i++)
            if (!nonPrime[i] && p.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) return i;

        return -1;
    }

    private static void sieve() {
        double sqrt = Math.sqrt(nonPrime.length);
        for (int i = 2; i < sqrt; i++)
            if (!nonPrime[i]) for (int j = i * i; j < nonPrime.length; j += i) nonPrime[j] = true;
    }

}
