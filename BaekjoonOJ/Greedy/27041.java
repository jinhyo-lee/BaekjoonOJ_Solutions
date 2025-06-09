import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int e = read(), l = read(), b = read();
        boolean[] arr = new boolean[e + 1];
        while (b-- > 0) arr[read()] = true;

        int i = 0, cnt = 0;
        while (i < e) {
            int j = Math.min(i + l, e);
            do if (!arr[j]) break; while (j-- > i);
            i = j;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
