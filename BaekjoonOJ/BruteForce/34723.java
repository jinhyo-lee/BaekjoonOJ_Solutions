import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = read(), m = read(), c = read(), x = read(), min = Integer.MAX_VALUE;
        for (int i = 1; i <= p; i++)
            for (int j = 1; j <= m; j++)
                for (int k = 1; k <= c; k++) min = Math.min(min, Math.abs((i + j) * (j + k) - x));

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
