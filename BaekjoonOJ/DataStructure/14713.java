import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<String>[] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[i].offer(st.nextToken());
        }

        bw.write(check(br.readLine()) ? "Possible" : "Impossible");
        bw.flush();
    }

    private static boolean check(String input) {
        st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            boolean flag = false;
            for (Queue<String> q : arr) {
                if (!q.isEmpty() && word.equals(q.peek())) {
                    q.poll();
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;
        }

        for (Queue<String> q : arr) {
            if (!q.isEmpty())
                return false;
        }

        return true;
    }

}
