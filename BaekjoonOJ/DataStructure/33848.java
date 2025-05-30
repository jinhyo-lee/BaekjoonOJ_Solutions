import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<>();
        Stack<Pair> bck = new Stack<>();
        int Q = read();
        while (Q-- > 0) {
            int q = read();
            if (q == 1) bck.push(new Pair(1, stk.push(read())));
            else if (q == 2) bck.push(new Pair(2, stk.pop()));
            else if (q == 3) {
                int j = read();
                while (j-- > 0) {
                    Pair p = bck.pop();
                    if (p.q == 1) stk.pop();
                    else if (p.q == 2) stk.push(p.v);
                    else q++;
                }
            } else sb.append(q == 4 ? stk.size() : !stk.isEmpty() ? stk.peek() : "-1").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair {
        int q, v;

        Pair(int q, int v) {
            this.q = q;
            this.v = v;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
