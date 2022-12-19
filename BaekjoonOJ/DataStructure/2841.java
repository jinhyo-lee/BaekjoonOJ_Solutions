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

        Stack<Integer>[] stk = new Stack[7];
        for (int i = 0; i <= 6; i++)
            stk[i] = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stk[line].empty() && stk[line].peek() > fret) {
                stk[line].pop();
                cnt++;
            }

            if (stk[line].empty() || stk[line].peek() < fret) {
                stk[line].push(fret);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
