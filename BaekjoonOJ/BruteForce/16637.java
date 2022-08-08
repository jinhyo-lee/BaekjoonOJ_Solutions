import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        input = new char[n];
        input = br.readLine().toCharArray();

        recur(input[0] - '0', 2);

        bw.write(max + "\n");
        bw.flush();
    }

    private static void recur(int res, int idx) {
        if (idx >= n) {
            max = Math.max(max, res);
            return;
        }

        recur(cal(res, input[idx] - '0', input[idx - 1]), idx + 2);

        if (idx + 2 < n) {
            int bracket = cal(input[idx] - '0', input[idx + 2] - '0', input[idx + 1]);
            recur(cal(res, bracket, input[idx - 1]), idx + 4);
        }
    }

    private static int cal(int x, int y, char op) {
        if (op == '+')
            return x + y;
        else if (op == '-')
            return x - y;
        else
            return x * y;
    }

}
