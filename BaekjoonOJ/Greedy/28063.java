import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), x = read(), y = read();

        if (n == 1) bw.write("0");
        else if ((x == 1 || x == n) && (y == 1 || y == n)) bw.write("2");
        else if (x == 1 || x == n || y == 1 || y == n) bw.write("3");
        else bw.write("4");

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
