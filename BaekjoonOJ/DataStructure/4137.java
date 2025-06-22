import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9'};
        Map<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringBuilder sb = new StringBuilder();
            for (char c : br.readLine().toCharArray()) if (c != '-') sb.append(Character.isDigit(c) ? c : arr[c - 'A']);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> e : map.entrySet()) format(e, sb);

        bw.write(sb.length() > 0 ? sb.toString() : "No duplicates.");
        bw.flush();
    }

    private static void format(Entry<String, Integer> e, StringBuilder sb) {
        if (e.getValue() > 1)
            sb.append(new StringBuilder(e.getKey()).insert(3, '-')).append(' ').append(e.getValue()).append('\n');
    }

}
