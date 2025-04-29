import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static StringBuilder s = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        int n = read(), cnt = 0, sum = 0;
        while (n-- > 0) {
            read();
            String s = readStr();
            int i = read();
            skip();
            if (map.getOrDefault(s, 0) == -1 || s.equals("megalusion")) continue;

            if (i == 4) {
                cnt++;
                sum += map.getOrDefault(s, 0);
                map.put(s, -1);
            } else map.put(s, map.getOrDefault(s, 0) + 1);
        }

        bw.write(String.valueOf(cnt == 0 ? 0 : (double) cnt / (cnt + sum) * 100.0));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

    private static String readStr() throws IOException {
        s.setLength(0);
        int c;
        while ((c = System.in.read()) > 47) s.append((char) c);

        return s.toString();
    }

    private static void skip() throws IOException {
        int c;
        while ((c = System.in.read()) != '\n') if (c == -1) break;
    }

}
