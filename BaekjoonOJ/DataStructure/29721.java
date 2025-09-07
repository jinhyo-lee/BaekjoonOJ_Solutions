import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Pair> set = new HashSet<>();
        int n = read(), k = read();
        int[][] mat = new int[k][2];
        while (k-- > 0) {
            mat[k][0] = read();
            mat[k][1] = read();
            set.add(new Pair(mat[k][0], mat[k][1]));
        }

        int[][] dir = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
        int cnt = 0;
        for (int[] arr : mat)
            for (int[] d : dir)
                if (inRange(arr[0] + d[0], arr[1] + d[1], n) && set.add(new Pair(arr[0] + d[0], arr[1] + d[1]))) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean inRange(int y, int x, int n) {
        return y > 0 && y <= n && x > 0 && x <= n;
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return y == p.y && x == p.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
