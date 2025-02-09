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
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine()), m = n * (n - 1) / 2;
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken(), B = st.nextToken();
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            map.putIfAbsent(A, 0);
            map.putIfAbsent(B, 0);

            if (a > b) map.put(A, map.get(A) + 3);
            else if (a < b) map.put(B, map.get(B) + 3);
            else {
                map.put(A, map.get(A) + 1);
                map.put(B, map.get(B) + 1);
            }
        }

        Pair[] arr = new Pair[map.size()];
        n = 0;
        for (String k : map.keySet()) arr[n++] = new Pair(k, map.get(k));

        Arrays.sort(arr);
        n = Math.min(5, arr.length);
        for (int i = 0; i < n; i++) sb.append(arr[i].s).append(" ").append(arr[i].i).append("\n");

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
