import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static List<String> list = new ArrayList<>();
    static Map<String, String> map = new HashMap<>();
    static Set<String> set = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = 1;
        String line;
        while ((line = br.readLine()).charAt(0) != '#') {
            do {
                StringTokenizer st = new StringTokenizer(line);
                String s = st.nextToken();
                list.add(s);
                map.put(s, st.nextToken());
            } while ((line = br.readLine()).charAt(0) != '#');

            sb.append("Party number ").append(i++).append("\n");
            for (String s : list) if (!set.contains(s)) dfs(s);

            list.clear();
            map.clear();
            set.clear();
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(String src) {
        sb.append(src);
        if (set.contains(src)) {
            sb.append(".\n");
            return;
        }
        sb.append(" to ");

        set.add(src);
        dfs(map.get(src));
    }

}
