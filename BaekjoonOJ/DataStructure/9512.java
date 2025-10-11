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
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String v = st.nextToken();
            while (st.hasMoreTokens()) map.put(st.nextToken().toLowerCase(), v);
        }

        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s, " .,;!?()");
            while (st.hasMoreTokens()) {
                String v = map.get(st.nextToken().toLowerCase());
                if (v == null) continue;
                sb.append(v).append('\n');
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
