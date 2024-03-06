import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Circle> q = new ArrayDeque<>();
        Circle prev = new Circle(0, 0, 0);

        int n = read();
        while (n-- > 0) {
            int y = read(), x = read(), r = read();
            if (y != 0 || x != 0) q.offer(new Circle(y, x, r));
            else prev.r = r;
        }

        while (q.size() > 1) {
            Circle cur = q.poll();
            if (Math.sqrt(Math.pow(prev.y - cur.y, 2) + Math.pow(prev.x - cur.x, 2)) == prev.r + cur.r) prev = cur;
            else q.offer(cur);
        }

        Circle dest = !q.isEmpty() ? q.poll() : new Circle(0, 0, 0);

        bw.write(dest.y + " " + dest.x);
        bw.flush();
    }

    private static class Circle {
        int y, x, r;

        Circle(int y, int x, int r) {
            this.y = y;
            this.x = x;
            this.r = r;
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
