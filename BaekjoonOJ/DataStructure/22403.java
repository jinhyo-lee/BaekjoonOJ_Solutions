import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            char c = br.readLine().charAt(0);
            if (c == 'A') stk.push(c);
            else if (stk.isEmpty()) break;
            else stk.pop();
        }

        bw.write(n == -1 && stk.isEmpty() ? "YES" : "NO");
        bw.flush();
    }

}
