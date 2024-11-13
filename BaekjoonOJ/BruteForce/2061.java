import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = find(new BigInteger(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(n == 0 ? "GOOD" : "BAD " + n);
        bw.flush();
    }

    private static int find(BigInteger k, int l) {
        boolean[] p = new boolean[l + 1];
        for (int i = 2; i < l; i++) {
            if (p[i]) continue;
            if (k.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) return i;
            for (int j = i + i; j <= l; j += i) p[j] = true;
        }

        return 0;
    }

}
