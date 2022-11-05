import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            dq.clear();
            st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < n; i++)
                dq.offer(Integer.parseInt(st.nextToken()));

            bw.write(ac(dq, p));
        }

        bw.flush();
    }

    private static String ac(Deque<Integer> dq, String p) {
        boolean reverse = false;

        for (char comm : p.toCharArray()) {
            if (comm == 'R')
                reverse = !reverse;
            else {
                if (dq.isEmpty())
                    return "error\n";

                if (reverse)
                    dq.removeLast();
                else
                    dq.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!dq.isEmpty()) {
            sb.append(reverse ? dq.removeLast() : dq.removeFirst());
            if (!dq.isEmpty())
                sb.append(',');
        }
        sb.append("]\n");

        return sb.toString();
    }

}
