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

        int n = read(), i, max = 0, min = 100000;
        while (n-- > 0) {
            if (read() == 1) {
                q.offer(i = read());

                if (max < q.size()) {
                    max = q.size();
                    min = i;
                } else if (max == q.size()) min = Math.min(min, i);
            } else q.poll();
        }

        sb.append(max).append(" ").append(min);

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
