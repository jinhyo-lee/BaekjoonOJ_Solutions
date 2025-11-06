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

        Map<String, int[]> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' '), j = s.indexOf(' ', i + 1);
            map.put(s.substring(0, i), new int[]{Integer.parseInt(s.substring(i + 1, j)), Integer.parseInt(s.substring(j + 1))});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prev = map.get(st.nextToken());
        int sum = 0;
        while (st.hasMoreTokens()) {
            int[] cur = map.get(st.nextToken());
            sum += Math.abs(prev[0] - cur[0]) + Math.abs(prev[1] - cur[1]);
            prev[0] = cur[0];
            prev[1] = cur[1];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
