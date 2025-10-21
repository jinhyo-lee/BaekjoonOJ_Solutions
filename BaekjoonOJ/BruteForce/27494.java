import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), cnt = 0;
        while (n > 2022) if (isValid(n--)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isValid(int n) {
        int i = 0;
        do if (match(i, n % 10)) if (++i == 4) return true; while ((n /= 10) > 0);

        return false;
    }

    private static boolean match(int i, int j) {
        return (i == 0 && j == 3) || ((i == 1 || i == 3) && j == 2) || (i == 2 && j == 0);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }


}
