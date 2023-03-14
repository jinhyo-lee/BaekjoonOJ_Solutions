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

        StringBuilder sb = new StringBuilder();
        int tc = 1;

        String input;
        while ((input = br.readLine()).charAt(0) != '-') {
            Stack<Character> stk = new Stack<>();
            int cnt = 0;

            for (int i = 0; i < input.length(); i++) {
                char token = input.charAt(i);
                if (token == '{')
                    stk.push(token);
                else if (stk.isEmpty()) {
                    stk.push('{');
                    cnt++;
                } else
                    stk.pop();
            }

            sb.append(tc++).append(". ").append(cnt + stk.size() / 2).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
