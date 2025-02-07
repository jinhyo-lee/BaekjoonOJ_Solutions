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

        Queue<Pair> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) q.offer(new Pair(br.readLine()));

        while (q.size() > 1) {
            Pair p = q.poll();
            while (p.i-- > 1) q.offer(q.poll());
            q.poll();
        }

        bw.write(q.remove().s);
        bw.flush();
    }

    private static class Pair {
        String s;
        int i;

        Pair(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.s = st.nextToken();
            this.i = Integer.parseInt(st.nextToken());
        }
    }

}
