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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken());

        Map<String, Boolean> map = new HashMap<>();
        while (p-- > 0) {
            String s = br.readLine();
            map.put(s.substring(0, s.indexOf(' ')), s.charAt(s.length() - 1) == 'W');
        }

        int sum = 0;
        while (n-- > 0 && sum < g) {
            Boolean flag = map.get(br.readLine());
            sum += flag == null || !flag ? -l : w;
            if (sum < 0) sum = 0;
        }

        bw.write(sum < g ? "I AM IRONMAN!!" : "I AM NOT IRONMAN!!");
        bw.flush();
    }

}
