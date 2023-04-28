import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat(" 0.00");

        for (String key : new String[]{"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"}) {
            int ratio = map.getOrDefault(key, 0);
            sb.append(key).append(" ").append(ratio).append(df.format(ratio / (double) cnt)).append("\n");
        }

        bw.write(sb.append("Total ").append(cnt).append(" 1.00").toString());
        bw.flush();
    }

}
