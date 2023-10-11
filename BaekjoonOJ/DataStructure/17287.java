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
        for (char c : br.readLine().toCharArray()) stk.push(c);

        int score = 0, max = 0;
        while (!stk.isEmpty()) {
            char c = stk.pop();
            switch (c) {
                case ']':
                    score += 3;
                    break;
                case '}':
                    score += 2;
                    break;
                case ')':
                    score += 1;
                    break;
                case '[':
                    score -= 3;
                    break;
                case '{':
                    score -= 2;
                    break;
                case '(':
                    score -= 1;
                    break;
                default:
                    max = Math.max(max, score);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
