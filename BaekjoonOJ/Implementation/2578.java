import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static boolean[][] mat = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) map.put(read(), new Pair(i, j));

        int cnt = 0;
        while (cnt++ < 50) if (isBingo(map.get(read()))) break;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isBingo(Pair p) {
        mat[p.y][p.x] = true;

        int cnt = 0, u = 0, d = 0;
        for (int i = 0; i < 5; i++) {
            int h = 0, v = 0;
            for (int j = 0; j < 5; j++) {
                if (mat[i][j]) h++;
                if (mat[j][i]) v++;
                if (mat[i][j] && i + j == 4) u++;
                if (mat[i][j] && i == j) d++;
            }

            if (h == 5) cnt++;
            if (v == 5) cnt++;
            if (u == 5) cnt++;
            if (d == 5) cnt++;
            if (cnt >= 3) return true;
        }

        return false;
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
