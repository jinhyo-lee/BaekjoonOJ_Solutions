import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int[][] mat = {{1, 2, 3, 3, 4, 10}, {1, 2, 2, 2, 3, 5, 10}};
            int a = 0, b = 0;
            for (int i = 0; i < 6; i++) a += mat[0][i] * read();
            for (int i = 0; i < 7; i++) b += mat[1][i] * read();
            sb.append("Battle ").append(tc).append(a > b ? ": Good triumphs over Evil\n" : a < b ? ": Evil eradicates all trace of Good\n" : ": No victor on this battle field\n");
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
