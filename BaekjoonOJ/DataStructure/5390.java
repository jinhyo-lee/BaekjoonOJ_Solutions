import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new LinkedHashSet<>();
        int t = read();
        while (t-- > 0) {
            int n = read();
            int[][] mat = new int[2][n];
            for (int i = 0; i < n; i++) mat[0][i] = read();
            for (int i = 0; i < n; i++) mat[1][i] = read();

            int i = 0, size = 0;
            for (int j = i; j < n; j++) {
                set.add(mat[0][j]);
                set.add(mat[1][j]);
                if (set.size() == ++size) {
                    sb.append(i + 1).append('-').append(i = j + 1).append(' ');
                    set.clear();
                    size = 0;
                }
            }
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
