import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read(), sum = 0, max = 0, r = 0;
            for (int i = 1, j; i <= n; i++) {
                sum += j = read();
                if (max < j) {
                    max = j;
                    r = i;
                } else if (max == j) r = 0;
            }

            if (r == 0) sb.append("no winner\n");
            else sb.append(max >= sum / 2 + 1 ? "majority" : "minority").append(" winner ").append(r).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
