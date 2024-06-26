import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int p, cnt;
    static int[] visit = new int[236197];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read();
        p = read();

        recur(a);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void recur(int a) {
        if (visit[a] == 2) return;
        visit[a]++;

        recur(calc(a));
        if (visit[a] == 1) cnt++;
    }

    private static int calc(int i) {
        double sum = 0;
        do sum += Math.pow(i % 10, p); while ((i /= 10) > 0);

        return (int) sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
