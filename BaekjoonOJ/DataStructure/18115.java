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

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int tmp;
        for (int i = 1; i <= n; i++) {
            int comm = arr[n - i];
            if (comm == 1)
                dq.offerLast(i);
            else if (comm == 2) {
                tmp = dq.pollLast();
                dq.offerLast(i);
                dq.offerLast(tmp);
            } else
                dq.offerFirst(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty())
            sb.append(dq.pollLast()).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

}
