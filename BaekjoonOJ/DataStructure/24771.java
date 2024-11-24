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
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new TreeMap<>();
        int n, t = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            while (n-- > 0) {
                String k = br.readLine();
                k = k.substring(k.lastIndexOf(" ") + 1).toLowerCase();
                map.put(k, map.getOrDefault(k, 0) + 1);
            }

            sb.append("List ").append(t++).append(":\n");
            for (String k : map.keySet()) sb.append(k).append(" | ").append(map.get(k)).append("\n");
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
