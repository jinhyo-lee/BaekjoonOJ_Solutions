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

        Map<Character, Integer> map = init();
        String s;
        while ((s = br.readLine()).charAt(0) != '#') {
            double sum = 0;
            for (int i = 0; i < s.length(); i++) sum += map.get(s.charAt(i)) * Math.pow(8, s.length() - i - 1);
            sb.append((int) sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<Character, Integer> init() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);

        return map;
    }

}
