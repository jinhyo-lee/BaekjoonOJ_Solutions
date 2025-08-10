import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int t = 1;
        String s;
        while ((s = br.readLine()).charAt(0) != '0') {
            sb.append("Case ").append(t++).append('\n');
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                s = combine(preprocess(br.readLine()), m);
                if (!map.containsKey(s)) map.put(s, 1);
                else s = addNumber(s, m, map);
                sb.append(s).append('\n');
            }
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) if (c != '\'' && c != '-') sb.append(c);

        return sb.toString();
    }

    private static String combine(String s, int m) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        sb.append(s.charAt(0)).append(s.substring(s.lastIndexOf(' ') + 1));

        return sb.substring(0, Math.min(m, sb.length()));
    }

    private static String addNumber(String s, int m, Map<String, Integer> map) {
        int i = map.get(s);
        map.put(s, map.getOrDefault(s, 0) + 1);

        if (s.length() >= m - (i > 9 ? 2 : 1)) s = s.substring(0, m - (i > 9 ? 2 : 1)) + i;
        else s += i;

        return s;
    }

}
