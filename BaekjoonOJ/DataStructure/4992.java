import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<>(), P = new Stack<>(), C = new Stack<>();
        int n;
        while ((n = read()) != 0) {
            for (int i = 1; i <= n; i++) stk.push(i);
            int r = read();
            while (r-- > 0) {
                int p = read(), c = read();
                while (p-- > 1) P.push(stk.pop());
                while (c-- > 0) C.push(stk.pop());
                while (!P.isEmpty()) stk.push(P.pop());
                while (!C.isEmpty()) stk.push(C.pop());
            }
            sb.append(stk.peek()).append("\n");
            stk.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
