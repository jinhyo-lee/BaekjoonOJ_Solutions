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
    static int[] visit;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            visit = new int[v + 1];
            isBipartite = false;

            for (int i = 1; i <= v; i++)
                graph[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                graph[src].add(dest);
                graph[dest].add(src);
            }

            for (int i = 1; i <= v; i++) {
                if (visit[i] == 0)
                    dfs(i, 1);
            }

            bw.write((isBipartite ? "NO" : "YES") + "\n");
        }

        bw.flush();
    }

    private static void dfs(int node, int color) {
        visit[node] = color;

        if (isBipartite)
            return;

        for (int i : graph[node]) {
            if (visit[i] == visit[node]) {
                isBipartite = true;
                return;
            }
            if (visit[i] == 0)
                dfs(i, color * -1);
        }
    }

}
