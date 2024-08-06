import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(find(read(), read(), read()));
        bw.flush();
    }

    private static String find(int s, int a, int b) {
        int q = s / a;
        do if ((s - (a * q)) % b == 0) return q + " " + (s - (a * q)) / b; while (q-- > 0);

        return "Impossible";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
