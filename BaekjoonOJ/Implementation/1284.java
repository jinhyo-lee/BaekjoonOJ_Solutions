import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) != 0) sb.append(calc(n)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int n) {
        int sum = 1, i;
        do sum += (i = n % 10) == 1 ? 3 : i == 0 ? 5 : 4; while ((n /= 10) > 0);

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
