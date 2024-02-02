import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t;
        while ((t = Integer.parseInt(br.readLine())) != 0) {
            Map<String, Integer> map = new HashMap<>();
            String[][] mat = new String[t][2];

            String s = "";
            int max = 0;
            for (int i = 0; i < t; i++) {
                char[] c = br.readLine().toCharArray();
                mat[i][0] = String.valueOf(c);

                Arrays.sort(c);
                String key = mat[i][1] = String.valueOf(c);

                int val = map.getOrDefault(key, -1) + 1;
                map.put(key, val);

                if (val > 0 && max < val) {
                    s = key;
                    max = val;
                }
            }

            for (String[] arr : mat) {
                if (arr[1].equals(s)) {
                    sb.append(arr[0]).append(" ");
                    break;
                }
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
