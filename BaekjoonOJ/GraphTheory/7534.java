import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 1; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), st.nextToken());
            }

            String key = findKey(n);

            sb.append("Scenario #").append(tc).append(":\n").append(key).append("\n");
            while (n-- > 1) sb.append(key = map.get(key)).append("\n");
            sb.append("\n");

            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String findKey(int n) {
        for (String key : map.keySet()) {
            String s = key;
            int i = n;
            while (i-- > 1 && map.containsKey(s)) s = map.get(s);

            if (i == 0) return key;
        }

        return "";
    }

}
