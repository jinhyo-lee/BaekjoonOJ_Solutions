import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            if (op.charAt(0) == 'E') break;
            sb.append("Case ").append(t++).append(": ").append(isValid(a, op, Integer.parseInt(st.nextToken()))).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isValid(int a, String op, int b) {
        switch (op) {
            case ">":
                return a > b;
            case ">=":
                return a >= b;
            case "<":
                return a < b;
            case "<=":
                return a <= b;
            case "==":
                return a == b;
            default:
                return a != b;
        }
    }

}
