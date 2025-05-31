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

    static Map<Character, Integer> map = init();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> op = new Stack<>();
        Stack<Integer> val = new Stack<>();

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.charAt(0) == '+' || s.charAt(0) == '*') op.push(s.charAt(0));
            else val.push(sum(s) * (!op.isEmpty() && op.pop() == '*' ? val.pop() : 1));
        }

        int sum = 0;
        while (!val.isEmpty()) sum += val.pop();

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int sum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) sum += map.get(c);

        return sum;
    }

    private static Map<Character, Integer> init() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('.', 1);
        map.put('-', 5);
        map.put(':', 2);
        map.put('=', 10);

        return map;
    }

}
