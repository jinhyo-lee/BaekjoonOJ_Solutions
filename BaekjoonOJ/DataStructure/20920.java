import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.length() >= m) map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (String s : map.keySet()) pq.offer(new Pair(s, map.get(s)));
        while (!pq.isEmpty()) sb.append(pq.poll().s).append('\n');

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
            return this.i != o.i ? o.i - this.i : this.s.length() != o.s.length() ? o.s.length() - this.s.length() : this.s.compareTo(o.s);
        }
    }

}
