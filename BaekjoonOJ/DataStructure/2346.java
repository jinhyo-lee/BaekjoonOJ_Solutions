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

        Deque<Pair> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            dq.offer(new Pair(i, Integer.parseInt(st.nextToken())));

        while (dq.size() > 1) {
            Pair cur = dq.poll();
            bw.write(cur.num + " ");

            int move = cur.move;
            if (move > 0) {
                for (int i = 0; i < move - 1; i++)
                    dq.offerLast(dq.pollFirst());
            } else {
                for (int i = 0; i < -move; i++)
                    dq.offerFirst(dq.pollLast());
            }
        }

        bw.write(String.valueOf(dq.poll().num));
        bw.flush();
    }

    private static class Pair {
        int num, move;

        public Pair(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }

}
