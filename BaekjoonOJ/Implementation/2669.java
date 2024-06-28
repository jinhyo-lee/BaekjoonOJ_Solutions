import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] mat = new boolean[101][101];
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int a = read(), b = read(), c = read(), d = read();
            for (int j = b; j < d; j++) {
                for (int k = a; k < c; k++) {
                    if (mat[j][k]) continue;
                    mat[j][k] = true;
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
