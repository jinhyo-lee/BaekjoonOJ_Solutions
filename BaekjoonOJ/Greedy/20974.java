import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), e = 0, o = 0;
        while (n-- > 0) {
            if (read() % 2 == 0) e++;
            else o++;
        }

        boolean flag = true;
        int cnt;
        for (cnt = 0; ; flag = !flag, cnt++) {
            if (flag) {
                if (e > 0) e--;
                else if (o > 1) o -= 2;
                else break;
            } else {
                if (o > 0) o--;
                else break;
            }
        }

        bw.write(String.valueOf(o == 0 ? cnt : cnt - 1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
