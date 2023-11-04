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

        Map<String, Integer> map = new HashMap<>();

        String key, res = "";
        int n = Integer.parseInt(br.readLine()), max = 0;
        for (int i = 0; i < n; i++) {
            map.put(key = br.readLine(), map.getOrDefault(key, 0) + 1);

            if (max < map.get(key)) {
                max = map.get(key);
                res = key;
            }
        }

        bw.write(max > n / 2 ? res : "NONE");
        bw.flush();
    }

}
