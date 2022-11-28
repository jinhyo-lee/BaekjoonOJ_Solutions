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

        String input = br.readLine();

        Stack<Character> stk = new Stack<>();
        int res = 0;
        int tmp = 1;

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (token == '(') {
                stk.push(token);
                tmp *= 2;
            } else if (token == '[') {
                stk.push(token);
                tmp *= 3;
            } else if (token == ')') {
                if (stk.empty() || stk.peek() != '(') {
                    res = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(')
                    res += tmp;

                stk.pop();
                tmp /= 2;
            } else if (token == ']') {
                if (stk.empty() || stk.peek() != '[') {
                    res = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[')
                    res += tmp;

                stk.pop();
                tmp /= 3;
            }
        }

        if (!stk.empty())
            res = 0;

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
