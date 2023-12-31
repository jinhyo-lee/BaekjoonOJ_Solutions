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
        int k = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        Map<Character, PriorityQueue<Pair>> map = new HashMap<>();
        while (k-- > 0) {
            String s = br.readLine();
            map.computeIfAbsent(s.charAt(0), pq -> new PriorityQueue<>()).add(new Pair(s));
        }

        while (n-- > 0) {
            char c = br.readLine().charAt(0);
            Pair p = map.get(c).poll();

            assert p != null;
            sb.append(p.s).append("\n");

            p.count();
            map.get(c).add(p);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        String s;
        int cnt;

        public Pair(String s) {
            this.s = s;
            this.cnt = 0;
        }

        public void count() {
            this.cnt++;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cnt == o.cnt ? this.s.compareTo(o.s) : this.cnt - o.cnt;
        }
    }

}
