import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stk = new Stack<>();
        int n = read();
        while (n-- > 0) {
            int i = read();
            if (!stk.isEmpty() && (stk.peek() + i & 1) == 0) stk.pop();
            else stk.push(i);
        }

        bw.write(String.valueOf(stk.size()));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
