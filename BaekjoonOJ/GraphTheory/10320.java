import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int tc = read();
        while (tc-- > 0) {
            int[] arr = new int[read()], dist = new int[3601];
            int t = read();

            for (int i = 0; i < arr.length; i++) arr[i] = read();
            Arrays.fill(dist, -1);
            dist[0] = 0;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(0);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i : arr) {
                    int nxt = cur + i;
                    nxt = nxt < 0 ? 0 : Math.min(nxt, 3600);

                    if (dist[nxt] != -1) continue;
                    dist[nxt] = dist[cur] + 1;
                    q.offer(nxt);
                }
            }

            int m = t;
            while (dist[m] == -1) m++;

            sb.append(dist[m]).append(" ").append(m - t).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
