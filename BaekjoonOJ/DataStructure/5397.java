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

        int n = Integer.parseInt(br.readLine());

        Stack<Character> stk = new Stack<>();
        Stack<Character> tmp = new Stack<>();

        while (n-- > 0) {
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                char token = input.charAt(i);
                if (token == '<') {
                    if (!stk.empty())
                        tmp.push(stk.pop());
                } else if (token == '>') {
                    if (!tmp.empty())
                        stk.push(tmp.pop());
                } else if (token == '-') {
                    if (!stk.empty())
                        stk.pop();
                } else
                    stk.push(token);
            }

            while (!stk.empty())
                tmp.push(stk.pop());

            StringBuilder sb = new StringBuilder();
            while (!tmp.empty())
                sb.append(tmp.pop());

            bw.write(sb.append("\n").toString());
        }

        bw.flush();
    }

}
