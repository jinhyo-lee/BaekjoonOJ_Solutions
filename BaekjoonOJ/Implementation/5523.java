import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), a = 0, b = 0;
        while (n-- > 0) {
            int i = read() - read();
            if (i > 0) a++;
            else if (i < 0) b++;
        }

        bw.write(sb.append(a).append(' ').append(b).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
