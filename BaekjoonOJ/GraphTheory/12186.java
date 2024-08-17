import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) map.put(br.readLine(), br.readLine());

            sb.append("Case #").append(tc).append(": ");
            for (String src : map.keySet()) {
                if (dfs(src, 0)) {
                    String key = src;
                    while (map.containsKey(key)) {
                        sb.append(key).append("-").append(map.get(key)).append(" ");
                        key = map.get(key);
                    }
                    sb.replace(sb.length() - 1, sb.length(), "\n");
                    break;
                }
            }
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean dfs(String src, int cnt) {
        if (cnt == map.size()) return true;
        else if (map.containsKey(src)) return dfs(map.get(src), cnt + 1);
        else return false;
    }

}
