import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] cache = new int[n];

        cache[0] = 1;
        cache[1] = 2;
        cache[2] = 4;
        for (int i = 3; i < n; i++) cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];

        bw.write(String.valueOf(cache[n - 1]));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
