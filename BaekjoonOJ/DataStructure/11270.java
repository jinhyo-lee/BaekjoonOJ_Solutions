import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new ArrayDeque<>();
        int n = read(), k = read(), max = 0;
        while (n-- > 0) {
            int i = read();
            while (!q.isEmpty() && q.peek() <= i - 1000) q.poll();

            max = Math.max(max, q.size());
            q.offer(i);
        }

        bw.write(String.valueOf((max + k) / k));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
