import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr;
    static int min = 999;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[]{read(), read(), read()};
        recur(0, new int[3], new boolean[10]);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void recur(int depth, int[] perm, boolean[] visit) {
        if (depth == 3) {
            if (perm[0] == 0) return;
            min = Math.min(min, perm[0] * 100 + perm[1] * 10 + perm[2]);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            perm[depth] = arr[i];
            recur(depth + 1, perm, visit);
            visit[i] = false;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
