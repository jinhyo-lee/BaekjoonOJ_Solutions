import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> a = new HashMap<>(), b = new HashMap<>();
        String s;
        while ((s = br.readLine()).charAt(0) != '-') {
            Pair p = new Pair(s);
            a.put(p.k, a.getOrDefault(p.k, 0) + p.v);
        }

        while ((s = br.readLine()).charAt(0) != '=') {
            Pair p = new Pair(s);
            b.put(p.k, b.getOrDefault(p.k, 0) + p.v);
        }

        Set<String> set = new TreeSet<>();
        set.addAll(a.keySet());
        set.addAll(b.keySet());

        for (String k : set) {
            int v = b.getOrDefault(k, 0) - a.getOrDefault(k, 0);
            if (v != 0) sb.append(k).append(v > 0 ? " +" : ' ').append(v).append('\n');
        }
        if (sb.length() == 0) sb.append("No differences found.");

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair {
        String k;
        int v;

        Pair(String s) {
            int i = s.indexOf(' '), j = s.lastIndexOf(' ');
            k = s.substring(j + 1);
            v = Integer.parseInt(s.substring(i + 1, j)) - Integer.parseInt(s.substring(0, i));
        }
    }

}
