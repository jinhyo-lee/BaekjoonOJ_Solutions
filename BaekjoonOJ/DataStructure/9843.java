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

        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(st.nextToken(), st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0);
        }

        Stack<Integer> stk = new Stack<>();
        int reg = 0;
        label:
        for (int i = 0; i < n; i++) {
            switch (arr[i].s) {
                case "PUSH":
                    stk.push(arr[i].i);
                    break;
                case "STORE":
                    reg = stk.pop();
                    break;
                case "LOAD":
                    stk.push(reg);
                    break;
                case "PLUS":
                    stk.push(stk.pop() + stk.pop());
                    break;
                case "TIMES":
                    stk.push(stk.pop() * stk.pop());
                    break;
                case "IFZERO":
                    if (stk.pop() == 0) i = arr[i].i - 1;
                    break;
                default:
                    break label;
            }
        }

        bw.write(String.valueOf(stk.peek()));
        bw.flush();
    }

    private static class Pair {
        String s;
        int i;

        Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }

}
