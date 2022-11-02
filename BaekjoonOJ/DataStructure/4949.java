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

        while (true) {
            String input = br.readLine();

            if (input.equals("."))
                break;

            stk.clear();
            for (int i = 0; i < input.length(); i++) {
                char token = input.charAt(i);

                if (token == '(' || token == '[')
                    stk.push(token);
                else if (token == ')' && !stk.empty() && stk.peek() == '(')
                    stk.pop();
                else if (token == ']' && !stk.empty() && stk.peek() == '[')
                    stk.pop();
                else if (token == ')' || token == ']')
                    stk.push(token);
            }

            bw.write((stk.empty() ? "yes" : "no") + "\n");
        }

        bw.flush();
    }

}
