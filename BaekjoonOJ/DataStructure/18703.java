import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (!map.containsKey(key) || (map.containsKey(key) && map.get(key) > val)) map.put(key, val);
            }

            for (int i : new TreeSet<>(map.values())) sb.append(i).append(" ");
            sb.append("\n");
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
