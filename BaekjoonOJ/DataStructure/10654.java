import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        Stack<Long> stk = new Stack<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            long reach = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) * t;

            while (!stk.empty() && stk.peek() >= reach) stk.pop();

            stk.push(reach);
        }

        bw.write(String.valueOf(stk.size()));
        bw.flush();
    }

}
