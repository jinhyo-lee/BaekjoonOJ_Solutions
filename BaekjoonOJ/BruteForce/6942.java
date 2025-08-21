import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = read(), n = read(), cnt = 0;
        while (m < n) if (m == calc(m++)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int calc(int m) {
        int sum = 0, i;
        do {
            if ((i = check(m % 10)) == -1) return -1;
            sum = sum * 10 + i;
        } while ((m /= 10) > 0);

        return sum;
    }

    private static int check(int i) {
        return i == 0 || i == 1 || i == 8 ? i : i == 6 ? 9 : i == 9 ? 6 : -1;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
