import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int n, k;
        while ((n = read()) != 0) {
            while (n-- > 0) map.put(k = read(), map.getOrDefault(k, 0) + 1);

            int max = 0;
            for (int v : map.values()) max = Math.max(max, v);

            sb.append(max).append("\n");
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
