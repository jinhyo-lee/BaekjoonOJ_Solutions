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

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            if (isLegal(br.readLine().split(" ")[1].toCharArray())) sb.append("legal\n");
            else sb.append("illegal\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isLegal(char[] arr) {
        Stack<Character> stk = new Stack<>();

        for (char c : arr) {
            if (!stk.empty() && c == '<' && stk.peek() == '>') stk.pop();
            else stk.push(c);
        }

        return stk.empty();
    }

}
