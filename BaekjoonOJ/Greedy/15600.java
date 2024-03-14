import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), range = 2, tgt = 0;
        while ((range - 1) % n != tgt && (range) % n != tgt && (range + 1) != tgt) {
            range += 2;
            tgt++;
        }

        bw.write(String.valueOf(Math.max(tgt, 1)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
