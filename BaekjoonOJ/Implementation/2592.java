import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0, mode = 0;
        for (int i = 0; i < 10; i++) {
            int n = read(), m = map.getOrDefault(n, 0) + 1;
            sum += n;
            map.put(n, m);
            if (max < m) {
                max = m;
                mode = n;
            }
        }

        bw.write(sum / 10 + "\n" + mode);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
