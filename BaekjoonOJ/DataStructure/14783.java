import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), l = read();
        Queue<Integer> q = new ArrayDeque<>();
        int[] arr = new int[l];

        for (int i = 1; i <= n; i++) q.offer(i);
        for (int i = 0; i < l; i++) arr[i] = read();

        int i = 0;
        do {
            int seq = arr[i++ % l];
            while (seq-- > 1) q.offer(q.poll());
            q.poll();
        } while (q.size() != 1);

        bw.write(String.valueOf(q.poll()));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
