import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        while (n-- > 0) {
            int k = read() + 1;
            while (contains(k)) k++;
            sb.append(k).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean contains(int n) {
        do if (n % 10 == 0) return true; while ((n /= 10) > 0);

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
