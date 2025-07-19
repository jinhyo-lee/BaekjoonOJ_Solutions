import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = read();
        for (int i = 0; i < n; i++) b[i] = read();

        int cnt = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) cnt += Integer.compare(a[i], b[j]);

        bw.write(cnt == 0 ? "tie" : cnt > 0 ? "first" : "second");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
