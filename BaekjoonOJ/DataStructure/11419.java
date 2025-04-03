import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        int n = read(), k = read();
        while (n-- > 0) {
            int c = read();
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        bw.write(String.valueOf(find(map, k)));
        bw.flush();
    }

    private static int find(Map<Integer, Integer> map, int k) {
        for (int key : map.keySet()) if (map.get(key) % k != 0) return key;

        return -1;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
