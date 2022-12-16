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

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            if (token == ')') {
                int val = 0;
                while (stk.peek() != 0)
                    val += stk.pop();

                stk.pop();
                stk.push(val);
            } else if (token == 'C')
                stk.push(12);
            else if (token == 'H')
                stk.push(1);
            else if (token == 'O')
                stk.push(16);
            else if (token >= '2' && token <= '9')
                stk.push(stk.pop() * (token - '0'));
            else
                stk.push(0);
        }

        int sum = 0;
        while (!stk.empty())
            sum += stk.pop();

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
