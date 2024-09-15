import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int Q = read();
        while (Q-- > 0) {
            int q = read();
            if (q == 1) hrz(read());
            else if (q == 2) vrt(read());
            else sb.append(map.getOrDefault(read(), 0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void hrz(int i) {
        int max = 0;
        for (int j = i + 3; j >= i; j--) max = Math.max(max, map.getOrDefault(j, 0));
        for (int j = i + 3; j >= i; j--) map.put(j, max + 1);
    }

    private static void vrt(int i) {
        map.put(i, map.getOrDefault(i, 0) + 4);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
