import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) for (char c : br.readLine().toCharArray()) if (c != ' ') map.put(c, map.getOrDefault(c, 0) + 1);

        for (Entry<Character, Integer> e : map.entrySet())
            sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
