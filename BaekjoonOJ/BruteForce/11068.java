import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean flag = false;
            for (int i = 2; i < 65 && !flag; i++, dq.clear())
                flag = isPalindrome(n, i);

            sb.append(flag ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPalindrome(int n, int radix) {
        do dq.offer(n % radix); while ((n /= radix) != 0);

        while (dq.size() > 1) if (!dq.poll().equals(dq.pollLast())) return false;

        return true;
    }

}
