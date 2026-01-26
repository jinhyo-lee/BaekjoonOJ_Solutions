import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        boolean[][] a = new boolean[n][n], b = new boolean[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] = read() == 1;
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) b[i][j] = read() == 1;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = false;
                for (int k = 0; k < n; k++) f = f || a[i][k] && b[k][j];
                if (f) sum++;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
