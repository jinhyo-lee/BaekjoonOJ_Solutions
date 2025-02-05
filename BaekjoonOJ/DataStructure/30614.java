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

        bw.write(isStable(Integer.parseInt(br.readLine()), br.readLine()) ? '1' : '0');
        bw.flush();
    }

    private static boolean isStable(int n, String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c > 96) stk.push(c);
            else if (stk.isEmpty() || stk.pop() - c != 32) return false;
        }

        return stk.isEmpty();
    }

}
