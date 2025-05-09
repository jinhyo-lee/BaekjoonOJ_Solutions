import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(calc(read(), read(), read()));
        bw.flush();
    }

    private static String calc(int n, int m, int k) {
        for (int i = 0; i <= k; i++)
            if ((n + i) % 3 == 0 && (m + k - i) % 4 == 0) return (n + i) / 3 + " " + (m + k - i) / 4;

        return "-1";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
