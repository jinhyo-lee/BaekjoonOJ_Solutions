import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[read()];
        int m = read();

        for (int i = 0; i < arr.length; i++) arr[i] = read();
        while (m-- > 0) {
            int i = read();
            for (int j : arr) if (i >= j) map.put(i - j, map.getOrDefault(i - j, 0) + 1);
        }

        int max = 0, dif = 0;
        for (Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if (max < v || (max == v && dif > k)) {
                dif = k;
                max = v;
            }
        }

        bw.write(String.valueOf(dif));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
