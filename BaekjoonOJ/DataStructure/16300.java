import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(compare(count(st.nextToken(), Integer.parseInt(st.nextToken())), count(br.readLine(), 1))));
        bw.flush();
    }

    private static int compare(Map<Character, Integer> a, Map<Character, Integer> b) {
        int min = Integer.MAX_VALUE;
        for (Entry<Character, Integer> e : b.entrySet()) {
            if (a.containsKey(e.getKey())) min = Math.min(min, a.get(e.getKey()) / e.getValue());
            else return 0;
        }

        return min;
    }

    private static Map<Character, Integer> count(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j; i < s.length(); i = j) {
            j = i + 1;
            while (j < s.length() && Character.isDigit(s.charAt(j))) j++;

            String cnt = s.substring(i + 1, j);
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + (cnt.isEmpty() ? k : Integer.parseInt(cnt) * k));
        }

        return map;
    }

}
