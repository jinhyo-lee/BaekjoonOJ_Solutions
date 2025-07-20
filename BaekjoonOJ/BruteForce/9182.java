import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1, p;
        while ((p = read()) != -1) {
            int e = read(), i = read(), d = read(), D = d++;
            while ((d - p) % 23 != 0 || (d - e) % 28 != 0 || (d - i) % 33 != 0) d++;
            sb.append("Case ").append(t++).append(": the next triple peak occurs in ").append(d - D).append(" days.\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
