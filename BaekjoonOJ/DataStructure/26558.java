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
        StringBuilder sb = new StringBuilder();

        Stack<String> a = new Stack<>(), b = new Stack<>(), c = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), "(");
                String s = st.nextToken().trim(), t = st.nextToken();
                if (t.startsWith("sh")) a.push(s);
                else if (t.startsWith("pa")) b.push(s);
                else c.push(s);
            }

            while (!a.isEmpty() && !b.isEmpty() && !c.isEmpty())
                sb.append(a.pop()).append(", ").append(b.pop()).append(", ").append(c.pop()).append("\n");
            sb.append("\n");

            a.clear();
            b.clear();
            c.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
