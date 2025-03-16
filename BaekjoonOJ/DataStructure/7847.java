import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Map<Integer, Integer>> map = new TreeMap<>();
        int n = read();
        while (n-- > 0) map.computeIfAbsent(read(), k -> new HashMap<>()).merge(read(), read(), Integer::sum);

        Set<Integer> set = new TreeSet<>();
        for (Map<Integer, Integer> v : map.values()) set.addAll(v.keySet());

        sb.append("-1");
        for (int k : map.keySet()) sb.append(' ').append(k);
        sb.append('\n');

        for (int k : set) {
            sb.append(k);
            for (Map<Integer, Integer> v : map.values()) sb.append(' ').append(v.getOrDefault(k, 0));
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
