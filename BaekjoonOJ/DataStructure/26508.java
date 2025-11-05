import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Character> a = new HashMap<>();
        Map<Character, String> b = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String s = br.readLine(), sub = s.substring(1);
            a.put(sub, s.charAt(0));
            b.put(s.charAt(0), sub);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int l = s.length();
            for (int i = 0, j = 0; i <= l - j; i += j) {
                if (s.charAt(i) == '#') {
                    sb.append(' ');
                    j = 1;
                    continue;
                }

                String sub = s.substring(i, i + 2);
                if (a.containsKey(sub)) {
                    sb.append(a.get(sub));
                    j = 2;
                } else {
                    sb.append(a.get(s.substring(i, i + 3)));
                    j = 3;
                }
            }
            sb.append('\n');
        }

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            for (char c : br.readLine().toCharArray()) sb.append(c == ' ' ? '#' : b.get(c));
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
