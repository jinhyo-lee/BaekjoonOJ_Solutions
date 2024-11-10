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

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int i = 1;
            String s;
            while ((s = br.readLine()) != null && !s.isEmpty()) {
                StringTokenizer st = new StringTokenizer(s);
                while (st.hasMoreTokens()) {
                    String k = st.nextToken();
                    if (!map.containsKey(k)) {
                        map.put(k, i++);
                        sb.append(k).append(" ");
                    } else sb.append(map.get(k)).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
