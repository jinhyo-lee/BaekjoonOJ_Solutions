import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        while (n-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);

            max = Math.max(max, map.get(key));
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String key : list) {
            if (map.get(key) == max) {
                bw.write(String.valueOf(key));
                break;
            }
        }

        bw.flush();
    }

}
