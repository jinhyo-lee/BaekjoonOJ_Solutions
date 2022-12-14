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
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        Deque<Character> dq = new ArrayDeque<>();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            dq.offer(st.nextToken().charAt(0));

            while (n-- > 1) {
                char token = st.nextToken().charAt(0);
                if (token <= dq.peekFirst())
                    dq.offerFirst(token);
                else
                    dq.offerLast(token);
            }

            while (!dq.isEmpty())
                bw.write(dq.poll());

            bw.write("\n");
            dq.clear();
        }

        bw.flush();
    }

}
