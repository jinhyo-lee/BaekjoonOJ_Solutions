import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        while (n-- > 0) sb.append(reverse(reverse(read()) + reverse(read()))).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int reverse(int i) {
        int n = i % 10;
        while ((i /= 10) > 0) n = n * 10 + i % 10;

        return n;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
