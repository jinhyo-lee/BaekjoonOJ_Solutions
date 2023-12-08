import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(n);
        while (n-- > 1) {
            dq.offerFirst(n);
            for (int i = 0; i < n; i++) dq.offerFirst(dq.pollLast());
        }

        for (int i : dq) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
