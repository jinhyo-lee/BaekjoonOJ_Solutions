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
        while (n-- > 0) map.put(br.readLine(), 0);

        int m = Integer.parseInt(br.readLine()), A = 0, B = 0;
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ": ");
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            String k = st.nextToken();

            map.put(k, map.getOrDefault(k, 0) + a - A + b - B);
            A = a;
            B = b;
        }

        String s = "";
        int max = 0;
        for (String k : map.keySet()) {
            if (map.get(k) <= max) continue;
            max = map.get(k);
            s = k;
        }

        bw.write(s + " " + max);
        bw.flush();
    }

}
