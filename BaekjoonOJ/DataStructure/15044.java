import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        int n = read(), k = read(), key;
        while (n-- > 0) map.put(key = read(), map.getOrDefault(key, 0) + 1);

        int sum = 0;
        for (int val : map.values()) {
            sum += val;
            if ((k -= val) < 1) break;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
