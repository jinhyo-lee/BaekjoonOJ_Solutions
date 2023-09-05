import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int t, b, n, r = 2;
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
        put(0, 0);
        put(1, 0);
    }};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read();
        t = read();
        b = read();

        while (loop()) r++;

        bw.write(String.valueOf(n % a));
        bw.flush();
    }

    private static boolean loop() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++, n++) {
                map.put(j, map.get(j) + 1);
                if (b == j && map.get(j) == t) return false;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < r; j++, n++) {
                map.put(i, map.get(i) + 1);
                if (b == i && map.get(i) == t) return false;
            }
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
