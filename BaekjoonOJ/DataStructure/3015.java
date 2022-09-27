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

        Stack<Pair> stk = new Stack<>();
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            Pair cur = new Pair(h, 1);

            while (!stk.empty() && stk.peek().height <= h) {
                Pair pair = stk.pop();
                cnt += pair.cnt;

                if (pair.height == h)
                    cur.cnt += pair.cnt;
            }

            if (!stk.empty())
                cnt++;
            stk.push(cur);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair {
        int height, cnt;

        public Pair(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

}
