import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int r = read(), c = read();
        mat = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) mat[i][j] = read();

        int max = 0, y = 0, x = 0;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int sum = sum(i, j);
                if (max >= sum) continue;
                max = sum;
                y = i;
                x = j;
            }
        }

        bw.write(sb.append(max).append("\n").append(y + 1).append(" ").append(x + 1).toString());
        bw.flush();
    }

    private static int sum(int r, int c) {
        int sum = 0;
        for (int i = r + 2; i >= r; i--) for (int j = c + 2; j >= c; j--) sum += mat[i][j];

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
