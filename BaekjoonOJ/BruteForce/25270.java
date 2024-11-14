import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(find(read())));
        bw.flush();
    }

    private static int find(int n) {
        int m = n;
        while (true) {
            if (++n % 100 == 99) return n;
            if (--m > 0 && m % 100 == 99) return m;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
