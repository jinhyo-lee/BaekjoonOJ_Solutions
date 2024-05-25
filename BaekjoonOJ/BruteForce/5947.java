import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read() + 1, nq = read() + 1, p = read();

        int[][] mat = new int[n][nq];
        for (int i = 1; i < n; i++) for (int j = 1; j < nq; j++) mat[i][j] = read();

        Pair[] arr = new Pair[p];
        for (int i = 0; i < p; i++) arr[i] = new Pair(read(), read());

        int cnt = 0;
        for (int i = 1; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < p; j++) flag &= mat[i][arr[j].q] == arr[j].a;
            if (flag) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair {
        int q, a;

        Pair(int q, int a) {
            this.q = q;
            this.a = a;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
