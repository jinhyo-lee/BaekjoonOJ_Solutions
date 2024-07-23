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
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> codes = init();
        Map<String, Integer> map = new HashMap<>();

        String s;
        while ((s = br.readLine()).charAt(0) != '#') {
            sb.append(s).append(" ");

            String key;
            while (!(s = br.readLine()).equals("00A"))
                map.put(key = s.substring(0, 3), map.getOrDefault(key, 0) + codes.getOrDefault(s.charAt(4), 0));

            int sum = 0;
            for (int val : map.values()) sum += val / 200;
            sb.append(sum).append("\n");

            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<Character, Integer> init() {
        Map<Character, Integer> codes = new HashMap<>();
        codes.put('L', 120);
        codes.put('S', 150);
        codes.put('B', 150);
        codes.put('N', 40);
        codes.put('C', 160);
        codes.put('D', 100);
        codes.put('R', 100);
        codes.put('O', 100);

        return codes;
    }

}
