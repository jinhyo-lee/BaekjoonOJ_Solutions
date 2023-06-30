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

        while (n-- > 0) {
            int speed = Integer.parseInt(br.readLine().split(" ")[1]);

            while (!stk.empty() && stk.peek() > speed) stk.pop();

            stk.push(speed);
        }

        bw.write(String.valueOf(stk.size()));
        bw.flush();
    }

}
