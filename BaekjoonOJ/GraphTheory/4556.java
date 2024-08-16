import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static Map<String, Integer> map = new HashMap<>();
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= n; tc++) {
            int x = Integer.parseInt(br.readLine());
            graph = new Node[x + 1];
            for (int i = 0; i <= x; i++) graph[i] = new Node(i);

            int i = 0;
            map.put("Ted", i++);
            while (x-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String u = st.nextToken(), v = st.nextToken();
                if (!map.containsKey(u)) map.put(u, i++);
                if (!map.containsKey(v)) map.put(v, i++);

                graph[map.get(u)].adj.add(new Pair(v, Integer.parseInt(st.nextToken())));
            }

            dfs("Ted", 0);
            Collections.sort(list);

            sb.append("DATASET ").append(tc).append("\n");
            for (Pair p : list) sb.append(p.s).append(" ").append(p.i).append("\n");

            map.clear();
            list.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(String src, int cnt) {
        for (Pair tgt : graph[map.get(src)].adj) {
            list.add(new Pair(tgt.s, 100 - cnt - tgt.i));
            dfs(tgt.s, cnt + tgt.i);
        }
    }

    private static class Node {
        int src;
        List<Pair> adj;

        Node(int src) {
            this.src = src;
            adj = new ArrayList<>();
        }
    }

    private static class Pair implements Comparable<Pair> {
        String s;
        int i;

        Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }

        @Override
        public int compareTo(Pair o) {
            return o.i != this.i ? o.i - this.i : this.s.compareTo(o.s);
        }
    }

}
