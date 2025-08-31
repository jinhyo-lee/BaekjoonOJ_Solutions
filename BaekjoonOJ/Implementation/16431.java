import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int br = read(), bc = read(), dr = read(), dc = read(), jr = read(), jc = read(), b = Math.max(Math.abs(br - jr), Math.abs(bc - jc)), d = Math.abs(dr - jr) + Math.abs(dc - jc);

        bw.write(b < d ? "bessie" : b > d ? "daisy" : "tie");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
