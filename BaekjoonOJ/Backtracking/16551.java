import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static boolean b;
    static int c;
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = read();
        while (p-- > 0) {
            sb.append(read());
            b = false;
            c = read();
            for (int i = 0; i < 10; i++) arr[i] = read();

            recur(0, 0);
            sb.append(b ? " YES\n" : " NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int i, int sum) {
        if (sum == c) {
            b = true;
            return;
        }
        if (b || i == 10) return;

        recur(i + 1, sum + arr[i]);
        recur(i + 1, sum);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
