import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Set<String>> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            Set<String> set = new HashSet<>();
            while (k-- > 0) set.add(st.nextToken());
            map.put(s, set);
        }

        List<String> list = new ArrayList<>(map.keySet());
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Set<String> set = map.get(list.get(i));
                int cnt = 0;
                for (String s : map.get(list.get(j))) if (set.contains(s)) cnt++;
                max = Math.max(max, cnt);
            }
        }

        bw.write(String.valueOf(max + 1));
        bw.flush();
    }

}
