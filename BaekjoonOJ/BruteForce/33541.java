import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() + 1;
        while (n < 10000 && !isSpecial(n, split(n))) n++;

        bw.write(n != 10000 ? String.valueOf(n) : "-1");
        bw.flush();
    }

    private static int[] split(int n) {
        int m = 0, j = 1;
        for (int i = 0; i < 2; i++, n /= 10, j *= 10) m += n % 10 * j;

        return new int[]{n, m};
    }

    private static boolean isSpecial(int n, int[] arr) {
        return (arr[0] + arr[1]) * (arr[0] + arr[1]) == n;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
