import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Map<Character, Pair> map = new HashMap<>();
    static Stack<Pair> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken().charAt(0), new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        String s;
        while ((s = br.readLine()) != null) sb.append((n = calc(s)) == -1 ? "error" : n).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(String s) {
        if (s.length() == 1) return 0;

        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                int i = mul();
                if (i == -1) return -1;
                else sum += i;
            } else if (c != '(') stk.push(map.get(c));
        }

        stk.clear();
        return sum;
    }

    private static int mul() {
        Pair b = stk.pop(), a = stk.pop();
        if (a.c != b.r) return -1;
        stk.push(new Pair(a.r, b.c));

        return a.r * a.c * b.c;
    }

    private static class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
