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

        Stack<Integer> stk = new Stack<>();
        for (char c : br.readLine().toCharArray()) stk.push(isDigit(c) ? c - '0' : calc(c, stk.pop(), stk.pop()));

        bw.write(String.valueOf(stk.peek()));
        bw.flush();
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int calc(char op, int a, int b) {
        if (op == '+') return a + b;
        else if (op == '-') return b - a;
        else if (op == '*') return a * b;
        else return b / a;
    }

}
