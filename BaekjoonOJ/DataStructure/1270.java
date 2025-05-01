import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            sb.append(state(br.readLine())).append('\n');
            map.clear();
            System.gc();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String state(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int t = Integer.parseInt(st.nextToken()), i = t / 2;
        while (t-- > 0) {
            long k = Long.parseLong(st.nextToken());
            int v = map.getOrDefault(k, 0) + 1;
            if (v > i) return String.valueOf(k);
            map.put(k, v);
        }

        return "SYJKGW";
    }

}
