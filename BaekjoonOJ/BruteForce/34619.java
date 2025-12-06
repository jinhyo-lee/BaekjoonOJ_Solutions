import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(find(read(), read(), read(), read()));
        bw.flush();
    }

    private static String find(int a, int b, int n, int k) {
        for (int i = 1; i <= a; i++)
            for (int j = 1; j <= b; j++) for (int l = 0; l < n; l++) if (--k == 0) return i + " " + j;

        return "";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
