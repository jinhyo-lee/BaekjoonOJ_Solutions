import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String w = st.nextToken();

            for (int i = 0; i < k; i++) count(w.charAt(i), 1);
            Map<Integer, Integer> map = new HashMap<>();
            map.put(getKey(), 1);

            int max = 0, key, value;
            for (int i = 0; i < w.length() - k; i++) {
                count(w.charAt(i), -1);
                count(w.charAt(i + k), 1);

                map.put(key = getKey(), value = map.getOrDefault(key, 0) + 1);
                max = Math.max(max, value);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void count(char c, int sign) {
        switch (c) {
            case 'A':
                arr[0] += sign;
                break;
            case 'G':
                arr[1] += sign;
                break;
            case 'T':
                arr[2] += sign;
                break;
            case 'C':
                arr[3] += sign;
                break;
        }
    }

    private static int getKey() {
        return arr[0] + arr[1] * 600 + arr[2] * 600 * 600 + arr[3] * 600 * 600 * 600;
    }

}
