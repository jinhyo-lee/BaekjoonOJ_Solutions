import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            skip();
            int[] a = new int[read()], b = new int[read()];
            for (int i = 0; i < a.length; i++) a[i] = read();
            for (int i = 0; i < b.length; i++) b[i] = read();

            Arrays.sort(a);
            Arrays.sort(b);

            int i = 0, j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) i++;
                else j++;
            }

            sb.append(i == a.length ? "MechaGodzilla\n" : "Godzilla\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

    private static void skip() throws IOException {
        int c;
        while ((c = System.in.read()) != '\n') if (c == -1) break;
    }

}
