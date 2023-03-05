import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int a, b, n, m;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, 100000);

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] dir = new int[]{1, -1, a, -a, b, -b, a, b};

        q.offer(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == m)
                break;

            for (int i = 0; i < 8; i++) {
                int next;
                if (i < 6)
                    next = cur + dir[i];
                else
                    next = cur * dir[i];

                if (next < 0 || next > 100000 || dist[next] <= dist[cur] + 1)
                    continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        return dist[m];
    }

}
