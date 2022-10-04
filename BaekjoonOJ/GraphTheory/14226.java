import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int s, res;
    static Queue<Emote> q;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine());

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void bfs() {
        q = new LinkedList<>();
        visit = new boolean[1001][1001];

        q.offer(new Emote(1, 0, 0));
        visit[1][0] = true;

        while (!q.isEmpty()) {
            Emote e = q.poll();

            if (e.print == s) {
                res = e.cnt;
                return;
            }

            if (!visit[e.print][e.print])
                operate(e.print, e.print, e.cnt + 1);

            if (e.print + e.copy <= s && !visit[e.print + e.copy][e.copy])
                operate(e.print + e.copy, e.copy, e.cnt + 1);

            if (e.print - 1 > 0 && !visit[e.print - 1][e.copy])
                operate(e.print - 1, e.copy, e.cnt + 1);
        }
    }

    private static void operate(int print, int copy, int cnt) {
        q.offer(new Emote(print, copy, cnt));
        visit[print][copy] = true;
    }

    private static class Emote {
        int print, copy, cnt;

        public Emote(int print, int copy, int cnt) {
            this.print = print;
            this.copy = copy;
            this.cnt = cnt;
        }
    }

}
