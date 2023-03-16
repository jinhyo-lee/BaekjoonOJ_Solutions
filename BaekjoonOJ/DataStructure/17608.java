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

        Stack<Integer> stk = new Stack<>();
        while (n-- > 0)
            stk.push(Integer.parseInt(br.readLine()));

        int max = stk.pop(), cnt = 1;
        while (!stk.empty()) {
            if (max < stk.peek())
                cnt++;

            max = Math.max(max, stk.pop());
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
