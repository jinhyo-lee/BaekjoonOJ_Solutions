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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, List<Team>> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            List<Team> v = map.getOrDefault(s, new ArrayList<>());
            v.add(new Team(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            map.put(s, v);
        }

        List<Team> list = new ArrayList<>();
        for (List<Team> v : map.values()) {
            Collections.sort(v);
            list.add(v.get(0));
        }

        Collections.sort(list);
        for (int i = 0; i < k; i++) sb.append(list.get(i).nm).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Team implements Comparable<Team> {
        String nm;
        int cnt, pnt;

        public Team(String nm, int cnt, int pnt) {
            this.nm = nm;
            this.cnt = cnt;
            this.pnt = pnt;
        }

        @Override
        public int compareTo(Team o) {
            return this.cnt != o.cnt ? o.cnt - this.cnt : this.pnt - o.pnt;
        }
    }

}
