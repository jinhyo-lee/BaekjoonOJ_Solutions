import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static long p, q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = read();
        p = read();
        q = read();
        map.put(0L, 1L);

        bw.write(String.valueOf(find(n)));
        bw.flush();
    }

    private static long find(long i) {
        if (map.containsKey(i)) return map.get(i);
        map.put(i, i = find(i / p) + find(i / q));

        return i;
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
