import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read(), i = read(), cnt = 0;
        while (--n > 0) {
            int j = read();
            if (i < j) i = j;
            else if (i < (j += k)) {
                i = j;
                cnt++;
            } else break;
        }

        bw.write(String.valueOf(n == 0 ? cnt : -1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
