import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new ArrayDeque<>();
        int[] cnt = new int[read()], arr = new int[cnt.length];
        for (int i = 0; i < cnt.length; q.offer(i++)) cnt[i] = read();

        int t = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            t++;
            if (--cnt[i] == 0) arr[i] = t;
            else q.offer(i);
        }

        for (int i : arr) sb.append(i).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
