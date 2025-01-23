import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(isExist(read(), read(), read()));
        bw.flush();
    }

    private static char isExist(int o, int a, int k) {
        int A = o / a, K = o / k;
        for (int i = 1; i <= A; i++) for (int j = 1; j <= K; j++) if (i * a + j * k == o) return '1';

        return '0';
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
