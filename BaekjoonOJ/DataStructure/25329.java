import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ": ");
            int minute = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + minute);
        }

        List<Pair> list = new ArrayList<>();
        for (String key : map.keySet()) list.add(new Pair(key, cost(map.get(key))));

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost == o2.cost ? o1.key.compareTo(o2.key) : o2.cost - o1.cost;
            }
        });

        for (Pair p : list) sb.append(p.key).append(" ").append(p.cost).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int cost(int i) {
        if (i > 100) return (i - 100) / 50 * 3 + (i % 50 > 0 ? 3 : 0) + 10;
        return 10;
    }

    private static class Pair {
        String key;
        int cost;

        Pair(String key, int cost) {
            this.key = key;
            this.cost = cost;
        }
    }

}
