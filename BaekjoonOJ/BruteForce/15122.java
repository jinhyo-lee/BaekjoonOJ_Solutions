import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() + 1;
        while (contains(n)) n++;

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static boolean contains(int i) {
        do if (i % 10 == 0) return true; while ((i /= 10) > 0);

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
