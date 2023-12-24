import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(isPossible(read(), read(), read(), read()));
        bw.flush();
    }

    private static String isPossible(int a, int b, int c, int n) {
        for (int i = 0; i <= n / a; i++)
            for (int j = 0; j <= n / b; j++)
                for (int k = 0; k <= n / c; k++)
                    if (a * i + b * j + c * k == n) return "1";

        return "0";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
