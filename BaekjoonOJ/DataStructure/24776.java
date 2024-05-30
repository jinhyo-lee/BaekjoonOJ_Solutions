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
        int val, max = 0;
        while (!(key = br.readLine()).startsWith("*")) {
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (max < (val = map.get(key))) {
                max = val;
                res = key;
            } else if (max == val) res = "Runoff!";
        }

        bw.write(res);
        bw.flush();
    }

}
