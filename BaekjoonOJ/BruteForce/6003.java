import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] mat = new int[read()][2];
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = read();
            mat[i][1] = read();
        }

        long min = Integer.MAX_VALUE, a = 0, b = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat.length; j++) {
                long d = dist(mat[i][0], mat[i][1], mat[j][0], mat[j][1]);
                if (min > d) {
                    min = d;
                    a = i;
                    b = j;
                }
            }
        }

        bw.write(++a + " " + ++b);
        bw.flush();
    }

    private static long dist(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
