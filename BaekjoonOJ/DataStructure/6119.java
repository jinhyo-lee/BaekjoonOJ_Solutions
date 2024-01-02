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

        Deque<Integer> dq = new ArrayDeque<>();

        int s = Integer.parseInt(br.readLine()), i = 1;
        while (s-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(), dir = st.nextToken();

            if (cmd.equals("A")) {
                if (dir.equals("L")) dq.offerFirst(i++);
                else dq.offerLast(+i++);
            } else {
                int n = Integer.parseInt(st.nextToken());
                if (dir.equals("L")) while (n-- > 0) dq.pollFirst();
                else while (n-- > 0) dq.pollLast();
            }
        }

        for (int n : dq) sb.append(n).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
