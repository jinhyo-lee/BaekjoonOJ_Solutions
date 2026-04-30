import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a;
        while ((a = read()) != 0) {
            int b = read(), d = 1;
            long[] arr = new long[10];
            while (a <= b) {
                while (a % 10 != 0 && a <= b) count(a++, d, arr);
                while (b % 10 != 9 && a <= b) count(b--, d, arr);
                if (a > b) break;

                int cnt = ((b /= 10) - (a /= 10) + 1) * d;
                for (int i = 0; i < 10; i++) arr[i] += cnt;
                d *= 10;
            }

            for (long i : arr) sb.append(i).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void count(int n, int d, long[] arr) {
        do arr[n % 10] += d; while ((n /= 10) > 0);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
