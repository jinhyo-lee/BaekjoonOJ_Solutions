import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int n = read();
        for (int t = 1; t <= n; t++) {
            int c = read(), g;
            while (c-- > 0) map.put(g = read(), map.getOrDefault(g, 0) + 1);

            int i = -1;
            for (Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() == 1) {
                    i = e.getKey();
                    break;
                }
            }

            sb.append("Case #").append(t).append(": ").append(i).append('\n');
            map.clear();
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
