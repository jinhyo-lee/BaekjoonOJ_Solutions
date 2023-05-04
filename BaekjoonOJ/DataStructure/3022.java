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

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            int value = map.getOrDefault(key, 0);
            if (value > i - value)
                cnt++;

            map.put(key, value + 1);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
