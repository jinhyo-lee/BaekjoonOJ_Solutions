import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(findOrder());
        bw.flush();
    }

    private static String findOrder() throws IOException {
        int n = read(), m;
        boolean a = false, d = false;

        for (int i = 0; i < 7; i++, n = m) {
            if (n < (m = read())) a = true;
            else d = true;
        }

        return a && d ? "mixed" : a ? "ascending" : "descending";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
