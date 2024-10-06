import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String[] arr = br.readLine().split(" ");
                map.put(arr[0], map.getOrDefault(arr[0], 0) + Integer.parseInt(arr[1]));
            }

            Pair[] arr = new Pair[map.size()];
            int i = 0;
            for (Entry<String, Integer> entry : map.entrySet()) arr[i++] = new Pair(entry.getKey(), entry.getValue());
            Arrays.sort(arr);

            sb.append(arr.length).append("\n");
            for (Pair p : arr) sb.append(p.s).append(" ").append(p.i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
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
