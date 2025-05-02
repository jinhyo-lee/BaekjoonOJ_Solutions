import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read();
            char[][] mat = new char[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) mat[i][j] = i == 0 || j == 0 || i == n - 1 || j == n - 1 ? '#' : 'J';

            for (int i = 0; i < n; i++, sb.append('\n')) for (int j = 0; j < n; j++) sb.append(mat[i][j]);
            sb.append('\n');
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
