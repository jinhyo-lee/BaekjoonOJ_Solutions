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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            dq.offer(i);

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int idx = 0;
                for (int tmp : dq) {
                    if (tmp == num)
                        break;
                    idx++;
                }

                if (idx == 0) {
                    dq.pollFirst();
                    break;
                }

                if (idx > dq.size() / 2)
                    dq.addFirst(dq.removeLast());
                else
                    dq.addLast(dq.removeFirst());

                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
