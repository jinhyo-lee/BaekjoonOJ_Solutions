import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new TreeMap<>();
        int total = 0;

        String input;
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double ratio = entry.getValue() * 100.0 / total;
            bw.write(entry.getKey() + String.format(" %.4f", ratio) + "\n");
        }

        bw.flush();
    }

}
