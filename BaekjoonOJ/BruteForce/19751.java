import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static double[] arr = new double[4], perm = new double[4], result;
    static boolean[] visit = new boolean[4];
    static double min = Double.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) arr[i] = read();
        recur(0);
        for (double d : result) sb.append((int) d).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int d) {
        if (d == 4) {
            min();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (visit[i]) continue;
            perm[d] = arr[i];
            visit[i] = true;
            recur(d + 1);
            visit[i] = false;
        }
    }

    private static void min() {
        double cur = perm[0] / perm[1] + perm[2] / perm[3];
        if (min > cur) {
            min = cur;
            result = perm.clone();
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
