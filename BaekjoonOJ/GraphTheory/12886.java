import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c, sum;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visit = new boolean[1001][1001];
        sum = a + b + c;

        if (sum % 3 != 0)
            bw.write(String.valueOf(0));
        else
            bw.write(String.valueOf(bfs() ? 1 : 0));

        bw.flush();
    }

    private static boolean bfs() {
        Queue<Group> q = new LinkedList<>();
        q.offer(new Group(a, b));
        visit[a][b] = true;
        visit[b][a] = true;

        while (!q.isEmpty()) {
            Group now = q.poll();

            int a = now.a;
            int b = now.b;
            int c = sum - a - b;

            if (a == b && b == c)
                return true;

            if (a != b) {
                int na = a > b ? a - b : a * 2;
                int nb = b > a ? b - a : b * 2;
                if (na <= 1000 && nb <= 1000 && !visit[na][nb]) {
                    visit[na][nb] = true;
                    visit[nb][na] = true;
                    q.offer(new Group(na, nb));
                }
            }

            if (a != c) {
                int na = a > c ? a - c : a * 2;
                int nc = c > a ? c - a : c * 2;
                if (na <= 1000 && nc <= 1000 && !visit[na][nc]) {
                    visit[na][nc] = true;
                    visit[nc][na] = true;
                    q.offer(new Group(na, nc));
                }
            }

            if (b != c) {
                int nb = b > c ? b - c : b * 2;
                int nc = c > b ? c - b : c * 2;
                if (nb <= 1000 && nc <= 1000 && !visit[nb][nc]) {
                    visit[nb][nc] = true;
                    visit[nc][nb] = true;
                    q.offer(new Group(nb, nc));
                }
            }
        }

        return false;
    }

    private static class Group {
        int a, b;

        public Group(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
