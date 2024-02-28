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

        String s;
        while (!(s = br.readLine()).equals("000-00-0000")) map.put(s, map.getOrDefault(s, 0) + 1);

        for (String key : map.keySet()) if (map.get(key) > 1) sb.append(key).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
