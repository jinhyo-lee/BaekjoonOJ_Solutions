import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] cache = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        bw.write((n < m ? recur(n, m) : recur(m, n)) == 1 ? "A" : "B");
        bw.flush();
    }

    private static int recur(int a, int b) {
        if (a == 2 || b == 2) return 1;
        if (cache[a][b] != 0) return cache[a][b];

        cache[a][b] = -1;
        for (int i = 1; i <= a >> 1; i++) if (recur(i, a - i) == -1) return cache[a][b] = 1;
        for (int i = 1; i <= b >> 1; i++) if (recur(i, b - i) == -1) return cache[a][b] = 1;

        return cache[a][b];
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
