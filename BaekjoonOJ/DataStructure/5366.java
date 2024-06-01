import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new LinkedHashMap<>();
        String s;
        int cnt = 0;
        while (!(s = br.readLine()).equals("0")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            cnt++;
        }

        for (Entry<String, Integer> e : map.entrySet())
            sb.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        sb.append("Grand Total: ").append(cnt);

        bw.write(sb.toString());
        bw.flush();
    }

}
