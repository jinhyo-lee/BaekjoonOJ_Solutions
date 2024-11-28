import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    static String a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Set<String>> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            divide(br.readLine());
            map.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }

        for (String k : map.keySet()) sb.append(k).append(" ").append(map.get(k).size()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void divide(String s) {
        int i = s.lastIndexOf(" ");
        a = s.substring(0, i);
        b = s.substring(i + 1);
    }

}
