import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int m;
    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) > 0) {
            m = read();
            mat = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) mat[i][j] = read();

            Sub sub = new Sub(0, 0), tgt;
            for (int i = n - m; i >= 0; i--)
                for (int j = n - m; j >= 0; j--) if (sub.compare(tgt = new Sub(i, j)) < 0) sub = tgt;

            sb.append(sub.y + 1).append(" ").append(sub.x + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }


    private static class Sub {
        int y, x;
        Set<Integer> set;

        Sub(int y, int x) {
            this.y = y;
            this.x = x;

            set = new HashSet<>();
            for (int i = y + m - 1; i >= y; i--)
                for (int j = x + m - 1; j >= x; j--) set.add(mat[i][j]);
        }

        public int compare(Sub tgt) {
            if (this.set.size() != tgt.set.size()) return tgt.set.size() - this.set.size();

            for (int i = 9; i >= 0; i--)
                if (this.set.contains(i) != tgt.set.contains(i))
                    return Boolean.compare(this.set.contains(i), tgt.set.contains(i));

            return this.y != tgt.y ? tgt.y - this.y : tgt.x - this.x;
        }
    }

    private static int read() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = n * 10 + c - 48;

        return n;
    }

}
