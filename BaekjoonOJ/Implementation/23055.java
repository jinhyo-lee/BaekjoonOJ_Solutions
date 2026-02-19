import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        for (int i = 1; i <= n; i++, sb.append('\n')) {
            if (i == 1 || i == n) for (int j = 0; j < n; j++) sb.append('*');
            else {
                sb.append('*');
                for (int j = 2; j < n; j++) sb.append(i == j || i == n - j + 1 ? '*' : ' ');
                sb.append('*');
            }
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
