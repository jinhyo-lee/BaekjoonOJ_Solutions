import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        graph = new int[n];
        for (int i = 0; i < n; i++)
            graph[i] = Integer.parseInt(br.readLine()) - 1;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            if (!dfs(i)) cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean dfs(int node) {
        if (graph[node] == -1) return false;

        if (visit[node]) return true;
        visit[node] = true;

        return dfs(graph[node]);
    }

}
