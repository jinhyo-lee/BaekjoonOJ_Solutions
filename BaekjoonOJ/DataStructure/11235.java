import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        String s;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) map.put(s = br.readLine(), map.getOrDefault(s, 0) + 1);

        Pair[] arr = new Pair[map.size()];
        for (String key : map.keySet()) arr[++n] = new Pair(key, map.get(key));

        Arrays.sort(arr);

        n = 0;
        for (Pair p : arr) {
            if (p.value < n) break;
            sb.append(p.key).append("\n");
            n = p.value;
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value != value ? o.value - value : key.compareTo(o.key);
        }
    }

}
