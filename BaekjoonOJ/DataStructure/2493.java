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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Tower> stk = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stk.empty()) {
                if (stk.peek().height >= height) {
                    bw.write(stk.peek().num + " ");
                    break;
                }

                stk.pop();
            }
            if (stk.empty())
                bw.write("0 ");

            stk.push(new Tower(i, height));
        }

        bw.flush();
    }

    private static class Tower {
        int num, height;

        public Tower(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

}
