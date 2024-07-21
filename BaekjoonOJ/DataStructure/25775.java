import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        while (n-- > 0) arr[n] = br.readLine();

        Map<Integer, Map<Character, Integer>> map = new TreeMap<>();
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                Map<Character, Integer> freq = map.getOrDefault(i, new TreeMap<>());
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
                map.put(i, freq);
            }
        }

        for (int i : map.keySet()) {
            Map<Character, Integer> freq = map.get(i);
            Set<Character> set = new TreeSet<>();

            int max = 0;
            for (Entry<Character, Integer> e : freq.entrySet()) {
                if (e.getValue() > max) {
                    set.clear();
                    set.add(e.getKey());
                    max = e.getValue();
                } else if (e.getValue() == max) set.add(e.getKey());
            }

            sb.append(i + 1).append(": ");
            for (Character c : set) sb.append(c).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
