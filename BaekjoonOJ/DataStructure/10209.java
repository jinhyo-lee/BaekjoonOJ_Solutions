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

        Stack<Character> stk = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= k; i++) {
            for (char c : br.readLine().toCharArray()) {
                if (stk.isEmpty() || !isRewound(stk.peek(), c)) stk.push(c);
                else stk.pop();
            }

            sb.append("Data Set ").append(i).append(":\n").append(stk.isEmpty() ? "Yes" : "No").append("\n\n");
            stk.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isRewound(char a, char b) {
        return (a == 'u' && b == 'd') || (a == 'd' && b == 'u') || (a == 'l' && b == 'r') || (a == 'r' && b == 'l');
    }

}
