import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = getDomain(br.readLine());
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Set<String> set = new HashSet<>();
        int max = 0;
        for (String k : map.keySet()) {
            int v = map.get(k);
            if (v < max) continue;
            if (v > max) {
                max = v;
                set.clear();
            }
            set.add(k);
        }

        sb.append(max).append("\n");
        for (String s : set) sb.append(s).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static String getDomain(String s) {
        int i = s.lastIndexOf(".");
        if (i != -1) s = s.substring(i + 1);
        else if ((i = s.indexOf("//")) != -1) s = s.substring(i + 2);

        return (i = s.indexOf("/")) == -1 ? s : s.substring(0, i);
    }

}
