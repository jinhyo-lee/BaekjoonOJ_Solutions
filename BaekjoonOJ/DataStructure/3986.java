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
        int cnt = 0;
        while (n-- > 0) {
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                if (!stk.empty() && input.charAt(i) == stk.peek())
                    stk.pop();
                else
                    stk.push(input.charAt(i));
            }

            if (stk.empty())
                cnt++;

            stk.clear();
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
