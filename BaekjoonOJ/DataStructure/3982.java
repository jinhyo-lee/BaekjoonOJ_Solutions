import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < 16; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken(), b = st.nextToken();

                if (Integer.parseInt(st.nextToken()) > Integer.parseInt(st.nextToken())) log(a, b);
                else log(b, a);
            }

            for (String key : map.keySet()) {
                if (map.get(key)) {
                    sb.append(key).append("\n");
                    break;
                }
            }

            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void log(String w, String l) {
        if (!map.containsKey(w)) map.put(w, true);
        map.put(l, false);
    }

}
