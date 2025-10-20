import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int max, n, m;
    static int[][] mat;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mat = new int[n = read()][m = read()];
        visit = new boolean[m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) mat[i][j] = read();

        recur(0, new int[3]);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int depth, int[] arr) {
        if (depth == 3) {
            max = Math.max(max, sum(arr));
            return;
        }

        for (int i = 0; i < m; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            arr[depth] = i;
            recur(depth + 1, arr);
            visit[i] = false;
        }
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j : arr) max = Math.max(max, mat[i][j]);
            sum += max;
        }

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
