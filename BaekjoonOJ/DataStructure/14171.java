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

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken().substring(0, 2);
            String value = st.nextToken();

            if (key.equals(value)) continue;

            String concat = key.concat(value);
            map.put(concat, map.getOrDefault(concat, 0) + 1);

            cnt += map.getOrDefault(value.concat(key), 0);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
