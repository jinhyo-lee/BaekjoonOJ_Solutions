import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger[] cache = new BigInteger[491];
        cache[0] = BigInteger.ZERO;
        cache[1] = BigInteger.ONE;
        for (int i = 2; i < cache.length; i++) cache[i] = cache[i - 1].add(cache[i - 2]);

        int n;
        while ((n = read()) != -1)
            sb.append("Hour ").append(n).append(": ").append(cache[n]).append(" cow(s) affected\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
