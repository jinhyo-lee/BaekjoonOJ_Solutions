import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Character> dq = new ArrayDeque<>();
        Collections.addAll(dq, 'A', 'B', 'C', 'D', 'E');

        int b;
        while ((b = read()) != 4) {
            int n = read();
            if (b == 1) while (n-- > 0) dq.addLast(dq.removeFirst());
            else if (b == 2) while (n-- > 0) dq.addFirst(dq.removeLast());
            else {
                while (n-- > 0) {
                    char f = dq.removeFirst(), s = dq.removeFirst();
                    dq.addFirst(f);
                    dq.addFirst(s);
                }
            }
        }

        for (char c : dq) sb.append(c).append(" ");
        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
