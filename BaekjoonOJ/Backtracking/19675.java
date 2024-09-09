import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] mat = new int[3][3];
    static List<Pair> list = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if ((mat[i][j] = read()) == 0) list.add(new Pair(i, j));
        recur(0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void recur(int idx) {
        if (idx == list.size()) {
            cnt++;
            return;
        }

        Pair p = list.get(idx);
        boolean[] arr = mark(p);

        for (int i = 1; i < 10; i++) {
            if (arr[i]) continue;
            mat[p.y][p.x] = i;
            recur(idx + 1);
            mat[p.y][p.x] = 0;
        }
    }

    private static boolean[] mark(Pair p) {
        boolean[] arr = new boolean[10];
        for (int i = 0; i < 3; i++) {
            arr[mat[p.y][i]] = true;
            arr[mat[i][p.x]] = true;
        }

        return arr;
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
