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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            dq.offer(i);

        int cnt = 0;
        int dir = 0;
        boolean flag = true;

        while (!dq.isEmpty()) {
            int cur;
            if (flag)
                cur = dq.pollFirst();
            else
                cur = dq.pollLast();
            cnt++;

            if (cnt == k) {
                cnt = 0;
                dir++;
                bw.write(cur + "\n");
            } else {
                if (flag)
                    dq.offerLast(cur);
                else
                    dq.offerFirst(cur);
            }

            if (dir == m) {
                dir = 0;
                flag = !flag;
            }
        }

        bw.flush();
    }

}
