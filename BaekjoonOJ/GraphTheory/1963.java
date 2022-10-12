import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int src, dest;
    static boolean[] nonPrime, visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sieve();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());

            int res = 0;
            if (src != dest) {
                visit = new boolean[10001];
                res = bfs();
            }

            bw.write((res != -1 ? res : "Impossible") + "\n");
        }

        bw.flush();
    }

    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));
        visit[src] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0)
                        continue;

                    int num = convert(cur.num, i, j);

                    if (!nonPrime[num] && !visit[num]) {
                        visit[num] = true;
                        if (num == dest)
                            return cur.cnt + 1;
                        else
                            q.offer(new Pair(num, cur.cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static void sieve() {
        nonPrime = new boolean[10000];
        for (int i = 2; i < 10000; i++) {
            if (!nonPrime[i]) {
                for (int j = i * i; j < 10000; j += i)
                    nonPrime[j] = true;
            }
        }
    }

    private static int convert(int num, int i, int j) {
        char[] pwd = Integer.toString(num).toCharArray();
        pwd[i] = (char) (j + '0');

        return Integer.parseInt(String.valueOf(pwd));
    }

    private static class Pair {
        int num, cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

}
