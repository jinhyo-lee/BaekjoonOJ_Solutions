import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        long res = 0;
        int max = 0;
        while (n-- > 0) {
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            } else if (map.get(key) == max)
                res = Math.min(res, key);
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
