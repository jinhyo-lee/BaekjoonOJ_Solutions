import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Long, Integer> map = new HashMap<>();
        final long BASE = 1315423911L;

        String s;
        while (!(s = removeBlank(br.readLine())).isEmpty()) {
            final int n = s.length();
            long[] h = new long[n + 1], p = new long[n + 1];
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                h[i] = h[i - 1] * BASE + s.charAt(i - 1);
                p[i] = p[i - 1] * BASE;
            }

            for (int i = 1; i <= n; i++, map.clear()) {
                int max = 0;
                for (int j = 0; j + i <= n; j++)
                    max = Math.max(max, map.merge(h[j + i] - h[j] * p[i], 1, Integer::sum));
                if (max == 1) break;
                sb.append(max).append('\n');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String removeBlank(String s) {
        if (s.isEmpty()) return "";

        int idx = 0;
        char[] arr = new char[s.length()];
        for (int i = 0; i < arr.length; i++) if (s.charAt(i) != ' ') arr[idx++] = s.charAt(i);

        return new String(arr, 0, idx);
    }

}
