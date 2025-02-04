import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = init();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            map.put(k, map.get(k) + Integer.parseInt(st.nextToken()));
        }

        Pair[] arr = new Pair[7];
        int i = 0;
        for (String k : map.keySet()) arr[i++] = new Pair(k, map.get(k));
        Arrays.sort(arr);

        int min = arr[0].v, cnt = 0;
        i = 1;
        for (; i < arr.length; i++) {
            if (arr[i].v == min) continue;
            min = arr[i].v;
            for (int j = i; j < arr.length; j++) if (arr[j].v == min) cnt++;
            break;
        }

        bw.write(cnt != 1 ? "Tie" : arr[i].k);
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        String k;
        int v;

        Pair(String k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return this.v - o.v;
        }
    }

    private static Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Bessie", 0);
        map.put("Elsie", 0);
        map.put("Daisy", 0);
        map.put("Gertie", 0);
        map.put("Annabelle", 0);
        map.put("Maggie", 0);
        map.put("Henrietta", 0);

        return map;
    }

}
