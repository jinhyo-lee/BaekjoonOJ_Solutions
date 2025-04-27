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

        Stack<String> stk = new Stack<>();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String s = br.readLine();
            if (s.charAt(0) == 'R') sb.append(stk.pop()).append('\n');
            else stk.push(s);
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
