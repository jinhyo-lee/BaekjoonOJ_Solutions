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

        int p = Integer.parseInt(br.readLine()), i = 0;
        while (p-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            while (n-- > 0) map.put(br.readLine(), 0);

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                map.put(key, map.get(key) + Integer.parseInt(st.nextToken()));
            }

            Pair[] arr = new Pair[map.size()];
            for (String key : map.keySet()) arr[++n] = new Pair(key, map.get(key));
            map.clear();

            Arrays.sort(arr);

            sb.append("VOTE ").append(++i);
            if (arr[0].value == arr[1].value) sb.append(": THERE IS A DILEMMA");
            else sb.append(": THE WINNER IS ").append(arr[0].key).append(" ").append(arr[0].value);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        String key;
        int value;

        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return o.value - value;
        }
    }

}
