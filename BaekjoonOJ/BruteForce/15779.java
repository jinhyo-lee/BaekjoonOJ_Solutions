import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), a = read(), b = read(), c, max = 0, cnt = 0;
        for (int i = 2; i < n; i++, a = b, b = c) {
            if (isContinuous(a, b, c = read())) {
                max = Math.max(max, cnt);
                cnt = 0;
            } else cnt++;
        }

        bw.write(String.valueOf(Math.max(max, cnt) + 2));
        bw.flush();
    }

    private static boolean isContinuous(int a, int b, int c) {
        return (a <= b && b <= c) || (a >= b && b >= c);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
