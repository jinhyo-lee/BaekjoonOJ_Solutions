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
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (token == '(')
                stk.push(token);
            else {
                if (stk.empty())
                    cnt++;
                else
                    stk.pop();
            }
        }

        cnt += stk.size();

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
