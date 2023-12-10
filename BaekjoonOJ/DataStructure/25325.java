import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) map.put(st.nextToken(), 0);

        String s;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) map.put(s = st.nextToken(), map.get(s) + 1);
        }

        int i = 0;
        for (String k : map.keySet()) arr[i++] = new Pair(k, map.get(k));

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.v != o2.v ? o2.v - o1.v : o1.k.compareTo(o2.k);
            }
        });

        for (Pair p : arr) sb.append(p.k).append(" ").append(p.v).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair {
        String k;
        int v;

        Pair(String k, int v) {
            this.k = k;
            this.v = v;
        }
    }

}
