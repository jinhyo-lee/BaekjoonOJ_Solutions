import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] a = new int[read()], b = new int[read()];
        for (int i = 0; i < a.length; i++) a[i] = read();
        for (int i = 0; i < b.length; i++) b[i] = read();

        int sum = 0;
        for (int i : a) for (int j : b) sum += (i + j) * Math.max(i, j);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
