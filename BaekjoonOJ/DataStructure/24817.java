import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        while (n-- > 0) map.put(br.readLine(), 0);

        Set<String> set = new HashSet<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            map.put(s, map.get(s) + Integer.parseInt(st.nextToken()));
            if (map.get(s) >= p && !set.contains(s)) {
                sb.append(s).append(" wins!\n");
                set.add(s);
            }
        }
        if (set.isEmpty()) sb.append("No winner!");

        bw.write(sb.toString());
        bw.flush();
    }

}
