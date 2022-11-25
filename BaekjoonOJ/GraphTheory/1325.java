import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dest = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken());

            graph[src].add(dest);
        }

        int[] result = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = bfs(i);
            result[i] = cnt;
            max = Math.max(max, cnt);
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] == max)
                bw.write(i + " ");
        }

        bw.flush();
    }

    private static int bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);

        boolean[] visit = new boolean[n + 1];
        visit[root] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int src = q.poll();

            for (int dest : graph[src]) {
                if (!visit[dest]) {
                    visit[dest] = true;
                    cnt++;
                    q.offer(dest);
                }
            }
        }

        return cnt;
    }

}
