import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[][] mat = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = read(), y = read();
            x = Math.abs(x - read());
            y = Math.abs(y - read());
            mat[i][0] = Math.min(x, y);
            mat[i][1] = Math.max(x, y);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) if (compare(mat[i][0], mat[j][0], mat[i][1], mat[j][1])) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean compare(int x1, int x2, int y1, int y2) {
        return x1 < x2 && y1 > y2 || x1 > x2 && y1 < y2;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
