import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, m, res;
    static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        m = read();
        for (int i = 0; i < m; i++) visit[read()] = true;

        recur(0, 0);

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void recur(int depth, int cnt) {
        if (depth == n) {
            if (cnt == m) res++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) {
                visit[i] = false;
                recur(depth + 1, cnt + 1);
                visit[i] = true;
            } else recur(depth + 1, cnt);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
