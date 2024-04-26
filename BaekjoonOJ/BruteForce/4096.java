import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static Deque<Integer> dq = new ArrayDeque<>();
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("0")) {
            len = s.length();

            int n = Integer.parseInt(s), cnt = 0;
            while (!isPalindrome(n++)) cnt++;

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPalindrome(int n) {
        dq.clear();
        int i = len - ((int) Math.log10(n) + 1);

        do dq.offer(n % 10); while ((n /= 10) != 0);
        while (i-- > 0) dq.offer(0);

        while (dq.size() > 1) if (!dq.poll().equals(dq.pollLast())) return false;

        return true;
    }

}
