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

        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) dq.add(i);

        String s = br.readLine();
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (c == 'A') dq.addLast(dq.removeFirst());
            else {
                int e = dq.removeFirst();
                dq.addLast(dq.removeFirst());
                dq.addFirst(e);
            }
        }

        bw.write(String.valueOf(dq.removeFirst()));
        bw.flush();
    }

}
