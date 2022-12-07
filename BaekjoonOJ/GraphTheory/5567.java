import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph[src].add(dest);
            graph[dest].add(src);
        }

        visit = new boolean[n + 1];
        visit[1] = true;

        dfs(1, 0);

        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (visit[i])
                res++;
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void dfs(int src, int cnt) {
        if (cnt == 2)
            return;

        for (int dest : graph[src]) {
            visit[dest] = true;
            dfs(dest, cnt + 1);
        }
    }

}
