import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = read(), n = read(), s = read();
        Pair[] arr = new Pair[n];
        while (n-- > 0) arr[n] = new Pair(read(), read());

        int[] dist = new int[1000001];
        Arrays.fill(dist, -1);
        dist[s] = 0;

        Queue<Long> q = new ArrayDeque<>();
        q.offer((long) s);
        while (!q.isEmpty()) {
            long cur = q.poll();
            if (cur == 0) break;

            for (Pair p : arr) {
                long tgt = (cur * p.a + p.b) % m;
                if (tgt >= dist.length || dist[(int) tgt] != -1) continue;

                dist[(int) tgt] = dist[(int) cur] + 1;
                q.offer(tgt);
            }
        }

        bw.write(String.valueOf(dist[0]));
        bw.flush();
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
