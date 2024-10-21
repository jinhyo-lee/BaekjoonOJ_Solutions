import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        while (l-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        while (n-- > 0) {
            String s = br.readLine();
            sb.append(map.containsKey(s) ? map.get(s) : plural(new StringBuilder(s)));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static StringBuilder plural(StringBuilder s) {
        int i = s.length();
        char c = s.charAt(i - 1);
        String t = s.substring(i - 2);
        if (c == 'o' || c == 's' || c == 'x' || t.equals("ch") || t.equals("sh")) return s.append("es");
        else if (c == 'y' && !set.contains(s.charAt(i - 2))) return s.replace(i - 1, i, "ies");

        return s.append("s");
    }

}
