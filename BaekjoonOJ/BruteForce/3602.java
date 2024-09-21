import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int b, w;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        b = read();
        w = read();

        if (b > 0 || w > 0) {
            if (b > w) swap();
            int i = 1;
            while (calc(i)) i++;
            bw.write(String.valueOf(i - 1));
        } else bw.write("Impossible");

        bw.flush();
    }

    private static boolean calc(int i) {
        int j = i * i / 2, k = i * i - j;

        return j <= b && k <= w;
    }

    private static void swap() {
        int tmp = b;
        b = w;
        w = tmp;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
