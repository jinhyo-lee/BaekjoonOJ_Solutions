import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), s = read(), d = read(), f = read(), b = read(), k = read();

        boolean[] visit = new boolean[n + 1];
        while (k-- > 0) visit[read()] = true;
        visit[s] = true;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(s, 0));

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.loc == d) {
                cnt = cur.cnt;
                break;
            }

            int front = cur.loc + f;
            int back = cur.loc - b;

            if (front <= n && !visit[front]) {
                visit[front] = true;
                q.offer(new Pair(front, cur.cnt + 1));
            }

            if (back > 0 && !visit[back]) {
                visit[back] = true;
                q.offer(new Pair(back, cur.cnt + 1));
            }
        }

        bw.write(cnt != 0 ? String.valueOf(cnt) : "BUG FOUND");
        bw.flush();
    }

    private static class Pair {
        int loc, cnt;

        Pair(int loc, int cnt) {
            this.loc = loc;
            this.cnt = cnt;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
