import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] inDegree = new int[n + 1];
        int[] cost = new int[n + 1];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for (int v = 1; v <= n; v++) {
            st = new StringTokenizer(br.readLine());
            cost[v] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cnt; i++) {
                int precede = Integer.parseInt(st.nextToken());

                list.get(precede).add(v);
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0){
                q.offer(i);
                res[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int v : list.get(node)) {
                inDegree[v]--;
                res[v] = Math.max(res[v], res[node] + cost[v]);

                if (inDegree[v] == 0)
                    q.offer(v);
            }
        }

        bw.write(Arrays.stream(res).max().getAsInt() + "\n");
        bw.flush();
    }

}
