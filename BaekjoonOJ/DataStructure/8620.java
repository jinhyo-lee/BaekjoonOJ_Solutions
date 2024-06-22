import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            map.put(c, map.getOrDefault(c, 0) + Integer.parseInt(st.nextToken()));
        }

        for (Entry<Character, Integer> e : map.entrySet())
            sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
