import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new ArrayDeque<>();
        String s;
        while ((s = br.readLine()).charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= n; i++) q.offer(i);

            int i = 0;
            while (q.size() > 1) {
                while (++i % m != 0) q.offer(q.poll());
                q.poll();
            }
            sb.append(q.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
