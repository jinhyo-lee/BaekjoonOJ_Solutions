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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (!map.containsKey(k)) map.put(k, new Pair(i, 0));

            Pair pair = map.get(k);
            pair.cnt++;
            map.put(k, pair);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Pair p1 = map.get(o1), p2 = map.get(o2);
                return p1.cnt == p2.cnt ? p1.idx - p2.idx : p2.cnt - p1.cnt;
            }
        });

        for (int i : list) {
            int j = map.get(i).cnt;
            while (j-- > 0) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair {
        int idx, cnt;

        Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

}
