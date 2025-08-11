import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Float> map = new HashMap<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            float sum = 0;
            while (x-- > 0) {
                st = new StringTokenizer(br.readLine());
                String k = st.nextToken();
                float v = Float.parseFloat(st.nextToken());
                map.put(k, v);
                sum += v;
            }

            List<String> list = new ArrayList<>();
            while (y-- > 0) {
                st = new StringTokenizer(br.readLine());
                String k = st.nextToken();
                float v = Float.parseFloat(st.nextToken());
                if (map.containsKey(k)) sum -= map.get(k) * v;
                else list.add(k);
            }

            sb.append(Math.round(sum * 100) / 100.0).append('\n');
            if (!list.isEmpty()) {
                sb.append("INVALID COUPONS\n");
                for (String k : list) sb.append(k).append('\n');
            }
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
