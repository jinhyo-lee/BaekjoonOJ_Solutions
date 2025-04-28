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

        Map<Character, Integer> map = new HashMap<>();
        int sum = 0, cnt = 0;
        String s;
        while ((s = br.readLine()).charAt(0) != '-') {
            StringTokenizer st = new StringTokenizer(s);
            int m = Integer.parseInt(st.nextToken());
            char p = st.nextToken().charAt(0);
            if (st.nextToken().charAt(0) == 'r') {
                int i;
                if (!map.containsKey(p)) i = 0;
                else if (map.get(p) != -1) i = map.getOrDefault(p, 0) * 20;
                else continue;
                sum += m + i;
                cnt++;
                map.put(p, -1);
            } else map.put(p, map.getOrDefault(p, 0) + 1);
        }

        bw.write(cnt + " " + sum);
        bw.flush();
    }

}
