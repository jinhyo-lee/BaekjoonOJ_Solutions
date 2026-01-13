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

        Map<String, String> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken(), k = a.charAt(0) + "" + b.charAt(0);
            map.put(k, map.containsKey(k) ? "ambiguous" : a + " " + b);
        }

        while (q-- > 0) sb.append(map.getOrDefault(br.readLine(), "nobody")).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

}
