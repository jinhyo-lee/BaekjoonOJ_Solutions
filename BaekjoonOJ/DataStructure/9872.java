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

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            char[] group = br.readLine().toCharArray();
            Arrays.sort(group);

            String key = new String(group);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;
        for (String key : map.keySet())
            max = Math.max(max, map.get(key));

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
