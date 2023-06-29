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

        Map<String, Integer> map = new HashMap<>();

        String key;
        for (int i = 0; i < n; i++)
            map.put(key = br.readLine(), map.getOrDefault(key, 0) + 1);

        int cnt = 0;
        while (n-- > 0) {
            key = br.readLine();
            if (map.containsKey(key) && map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
