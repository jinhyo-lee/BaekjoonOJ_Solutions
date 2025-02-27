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
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int sum = map.get(s.charAt(s.length() - 1));
            for (int i = s.length() - 2; i >= 0; i--)
                sum += map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ? -map.get(s.charAt(i)) : map.get(s.charAt(i));

            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<Character, Integer> init() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }

}
