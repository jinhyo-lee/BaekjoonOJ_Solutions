import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, List<String>> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken(), s = st.nextToken();
            if (s.charAt(0) == '-') continue;

            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(p);
            map.put(s, list);
        }

        int cnt = 0;
        for (List<String> list : map.values()) {
            if (list.size() != 2) continue;
            sb.append(list.get(0)).append(" ").append(list.get(1)).append("\n");
            cnt++;
        }

        bw.write(sb.insert(0, cnt + "\n").toString());
        bw.flush();
    }

}
