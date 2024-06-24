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
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Stack<Integer> stk = new Stack<>();
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            String s = st.nextToken();
            if (s.charAt(0) == 'u') for (int m = Integer.parseInt(st.nextToken()); m > 0; m--) stk.pop();
            else stk.push(Integer.parseInt(s));
        }

        int sum = 0;
        while (!stk.isEmpty()) sum += stk.pop();
        sum %= n;

        bw.write(String.valueOf(sum < 0 ? n + sum : sum));
        bw.flush();
    }

}
