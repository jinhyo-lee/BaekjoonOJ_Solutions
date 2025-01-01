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

    static Map<Character, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (char i = 'A'; i <= 'Z'; i++) map.put(i, Integer.parseInt(st.nextToken()));

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) set.add(encode(br.readLine()));

            sb.append("Case #").append(tc).append(": ").append(set.size() < n ? "YES\n" : "NO\n");
            map.clear();
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) sb.append(map.get(s.charAt(i)));

        return sb.toString();
    }

}
