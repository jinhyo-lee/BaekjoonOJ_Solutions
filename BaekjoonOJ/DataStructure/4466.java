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

        int x = Integer.parseInt(br.readLine());
        for (int i = 1; i <= x; i++) {
            String s = br.readLine();
            for (char c : s.substring(0, s.indexOf(' ')).toCharArray())
                stk.push(c == ')' ? evaluation() ? 't' : 'f' : c);

            if (stk.size() == 2) stk.push(stk.pop() == 't' ? 'f' : 't');
            sb.append(i).append(": ").append(stk.pop() == s.substring(s.indexOf(' ') + 3).charAt(0) ? "Good" : "Bad").append(" brain\n");
            stk.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean evaluation() {
        StringBuilder sb = new StringBuilder();
        char c;
        while ((c = stk.pop()) != '(') sb.append(c);

        int i = sb.length() - 1;
        boolean a = sb.charAt(i) == '!' ? sb.charAt(--i) != 't' : sb.charAt(i) == 't', b = false;
        char o = ' ';
        while (--i >= 0) {
            if ((c = sb.charAt(i)) == '&' || c == '|') o = c;
            else b = c == '!' ? sb.charAt(--i) != 't' : c == 't';
        }

        return o == '&' ? a && b : a || b;
    }

}
