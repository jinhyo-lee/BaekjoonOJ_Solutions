import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    static Map<Integer, Pair> intMap = new HashMap<>();
    static Map<Pair, Integer> pairMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        init();

        int t = read();
        while (t-- > 0) {
            Pair a = intMap.get(read()), b = intMap.get(read()), c = new Pair(a.y + b.y, a.x + b.x);
            sb.append(pairMap.get(c)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void init() {
        int seq = 1;
        for (int i = 1, y = seq, x = 1; i <= 45000; i++) {
            intMap.put(i, new Pair(y, x));
            pairMap.put(new Pair(y--, x++), i);
            if (y == 0) {
                y = ++seq;
                x = 1;
            }
        }
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;

            Pair p = (Pair) o;
            return this.y == p.y && this.x == p.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
