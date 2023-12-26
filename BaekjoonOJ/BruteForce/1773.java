import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), c = read(), p;
        boolean[] arr = new boolean[c + 1];

        while (n-- > 0) for (int i = p = read(); i <= c; i += p) arr[i] = true;

        int cnt = 0;
        for (boolean b : arr) if (b) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
