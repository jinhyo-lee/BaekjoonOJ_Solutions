import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        Deque<Integer> dq = new ArrayDeque<>();
        while (m-- > 0) dq.offer(m);

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'A') dq.addFirst(dq.removeLast());
            else {
                int n = dq.removeLast();
                dq.addFirst(dq.removeLast());
                dq.addLast(n);
            }
        }

        while (k-- > 1) dq.removeLast();
        for (int i = 0; i < 3; i++) sb.append(dq.removeLast()).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

}
