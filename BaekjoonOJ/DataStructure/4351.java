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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        while (n-- > 0) {
            int sum = 0;
            String s;
            while (!(s = br.readLine()).equals(".")) {
                st = new StringTokenizer(s);
                while (st.hasMoreTokens()) sum += map.getOrDefault(st.nextToken(), 0);
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
