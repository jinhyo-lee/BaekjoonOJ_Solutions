import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] p = new Pair[read()], q = new Pair[read()];
        for (int i = 0; i < p.length; i++) p[i] = new Pair(read(), read());
        for (int i = 0; i < q.length; i++) q[i] = new Pair(read(), read());

        double max = 0;
        for (Pair i : p) for (Pair j : q) max = Math.max(max, Math.pow(i.y - j.y, 2) + Math.pow(i.x - j.x, 2));

        bw.write(String.valueOf((long) max));
        bw.flush();
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
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
