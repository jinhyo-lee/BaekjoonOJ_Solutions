import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        int k = Integer.parseInt(br.readLine());
        for (int t = 1; t <= k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }

            int cnt = 0, sum = 0;
            st = new StringTokenizer(br.readLine());
            while (m-- > 0) {
                String s = st.nextToken();
                if (s.charAt(0) == '?') cnt++;
                else sum += map.remove(s);
            }

            int i = 0;
            int[] arr = new int[map.size()];
            for (int v : map.values()) arr[i++] = v;
            Arrays.sort(arr);

            int min = sum, max = sum;
            while (cnt-- > 0) {
                min += arr[cnt];
                max += arr[arr.length - cnt - 1];
            }

            sb.append("Data Set ").append(t).append(":\n").append(min).append(" ").append(max).append("\n\n");
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
