import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Value> map = new HashMap<>();
        PriorityQueue<Value> pq = new PriorityQueue<>();
        int n;
        while ((n = read()) != 0) {
            while (n-- > 0) {
                int d = read();
                for (int i = 0; i < d; i++) {
                    int k = read();
                    map.put(k, map.getOrDefault(k, new Value(k)).increment(i));
                }
            }
            pq.addAll(map.values());

            Value v = pq.remove();
            sb.append(v.k).append(' ');
            while (!pq.isEmpty()) {
                Value ov = pq.poll();
                if (v.t == ov.t && v.a == ov.a && v.b == ov.b) sb.append(ov.k).append(' ');
                else break;
            }
            sb.append('\n');

            map.clear();
            pq.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Value implements Comparable<Value> {
        int k, a = 0, b = 0, c = 0, t = 0;

        Value(int k) {
            this.k = k;
        }

        public Value increment(int i) {
            if (i == 0) {
                a++;
                t += 3;
            } else if (i == 1) {
                b++;
                t += 2;
            } else {
                c++;
                t++;
            }

            return this;
        }

        @Override
        public int compareTo(Value o) {
            return o.t != t ? o.t - t : o.a != a ? o.a - a : o.b != b ? o.b - b : k - o.k;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
