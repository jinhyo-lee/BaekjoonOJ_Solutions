import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(isConnected(read() * 2, read()) ? "Yes" : "No");
        bw.flush();
    }

    private static boolean isConnected(int n, int i) {
        int j = i % 10;
        while (n-- > 0) {
            if ((i /= 10) % 10 == j) return false;
            j = i % 10;
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
