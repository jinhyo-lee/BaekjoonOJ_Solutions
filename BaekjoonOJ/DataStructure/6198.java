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
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stk.empty() && stk.peek() <= h)
                stk.pop();

            cnt += stk.size();
            stk.push(h);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
