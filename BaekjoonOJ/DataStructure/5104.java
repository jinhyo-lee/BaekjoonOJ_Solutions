import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = init(), lmap = new LinkedHashMap<>();
        String s;
        while ((s = br.readLine()).charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(s);
            sb.append("Week ").append(st.nextToken()).append(" ");

            int n = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                String k = st.nextToken();
                lmap.put(k, lmap.getOrDefault(k, 0) + map.get(st.nextToken()));
            }

            for (String k : lmap.keySet()) if (lmap.get(k) >= 100) sb.append(k).append(",");

            if (sb.charAt(sb.length() - 1) == ' ') sb.append("No phones confiscated\n");
            else sb.setCharAt(sb.length() - 1, '\n');
            lmap.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        map.put("TT", 75);
        map.put("TX", 50);
        map.put("PR", 80);
        map.put("RT", 30);
        map.put("AP", 25);
        map.put("PX", 60);

        return map;
    }

}
