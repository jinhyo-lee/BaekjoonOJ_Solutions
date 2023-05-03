import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());

        String word = null;
        int max = 0;
        for (String key : list) {
            int val = map.get(key);
            if (val > max) {
                max = val;
                word = key;
            }
        }

        bw.write(word + " " + max);
        bw.flush();
    }

}
