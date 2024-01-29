import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static String w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            w = st.nextToken();

            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for (int i = 0; i <= w.length() - k; i++) {
                int key = getKey(i), value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);

                max = Math.max(max, value);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getKey(int i) {
        int key = 0;
        for (int j = 0; j < k; j++) {
            char c = w.charAt(i + j);
            switch (c) {
                case 'A':
                    key++;
                    break;
                case 'G':
                    key += 600;
                    break;
                case 'T':
                    key += 360000;
                    break;
                case 'C':
                    key += 216000000;
                    break;
            }
        }

        return key;
    }

}
