import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long s, t;
    static String[] ops = {"*", "+"};
    static String res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if (s == t)
            res = "0";
        else if (t == 0)
            res = "-";
        else if (t == 1)
            res = "/";
        else
            res = bfs();

        bw.write(res);
        bw.flush();
    }

    private static String bfs() {
        Queue<Pair> q = new LinkedList<>();
        HashSet<Long> set = new HashSet<>();

        q.offer(new Pair(s * s, "*"));
        q.offer(new Pair(s * 2, "+"));
        q.offer(new Pair(1, "/"));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.num == t)
                return cur.op;

            if (cur.num > t)
                continue;

            for (int i = 0; i < 2; i++) {
                long next = operation(cur.num, i);

                if (next != -1 && !set.contains(next)) {
                    set.add(next);
                    q.offer(new Pair(next, cur.op + ops[i]));
                }
            }
        }

        return "-1";
    }

    private static long operation(long num, int op) {
        if (op == 0) {
            if (num * num <= t && num != 1)
                return num * num;
        } else {
            if (num * 2 <= t && num != 2)
                return num * 2;
        }

        return -1;
    }

    private static class Pair {
        long num;
        String op;

        public Pair(long num, String op) {
            this.num = num;
            this.op = op;
        }
    }

}
