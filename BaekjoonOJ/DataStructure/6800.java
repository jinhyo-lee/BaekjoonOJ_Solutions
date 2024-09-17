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

        Map<String, Character> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            map.put(st.nextToken(), c);
        }

        String s = br.readLine();
        while (!s.isEmpty()) {
            for (String k : map.keySet()) {
                if (!s.startsWith(k)) continue;
                sb.append(map.get(k));
                s = s.substring(k.length());
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
