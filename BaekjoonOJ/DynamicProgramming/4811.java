import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long[][] cache = new long[31][31];
        for (int i = 1; i < 31; i++) cache[0][i] = 1;

        for (int i = 1; i < 31; i++) {
            cache[i][0] = cache[i - 1][1];
            for (int j = 1; j < 30; j++) cache[i][j] = cache[i - 1][j + 1] + cache[i][j - 1];
        }

        int n;
        while ((n = read()) != 0) sb.append(cache[n][0]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
