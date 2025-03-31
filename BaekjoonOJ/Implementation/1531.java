import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] mat = new int[101][101];
        int n = read(), m = read();
        while (n-- > 0) {
            int lx = read(), ly = read(), rx = read(), ry = read();
            for (int i = lx; i <= rx; i++) for (int j = ly; j <= ry; j++) mat[i][j]++;
        }

        int cnt = 0;
        for (int i = 1; i < 101; i++) for (int j = 1; j < 101; j++) if (mat[i][j] > m) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
