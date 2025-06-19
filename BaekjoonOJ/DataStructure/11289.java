import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Boolean> stk = new Stack<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                char c = st.nextToken().charAt(0);
                if (c == '1') stk.push(true);
                else if (c == '0') stk.push(false);
                else if (c == 'N') stk.push(!stk.pop());
                else {
                    boolean a = stk.pop(), b = stk.pop();
                    if (c == 'A') stk.push(a && b);
                    else if (c == 'R') stk.push(a || b);
                    else if (c == 'X') stk.push(a != b);
                }
            }
            bw.write(stk.pop() ? "1\n" : "0\n");
        }

        bw.flush();
    }

}
