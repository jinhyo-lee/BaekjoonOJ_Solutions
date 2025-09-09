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

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (i++ < n) {
            String k = st.nextToken();
            int v = map.getOrDefault(k, 0) + 1;
            if (v == 5) break;
            map.put(k, v);
        }

        bw.write(i > n ? "0" : String.valueOf(i));
        bw.flush();
    }

}
