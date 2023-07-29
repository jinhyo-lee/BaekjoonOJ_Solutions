import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    static Stack<Character> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("#")) {
            sb.append(isLegal(input) ? "Legal\n" : "Illegal\n");
            stk.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isLegal(String input) {
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stk.push(c);
            else if (c == ')' && stk.pop() != '(') return false;
            else if (c == ']' && stk.pop() != '[') return false;
            else if (c == '}' && stk.pop() != '{') return false;
        }

        return stk.isEmpty();
    }

}
