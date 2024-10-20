import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = read();
        for (int i = 0; i < n; i++) b[i] = read();

        Map<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) map.put(b[n] - a[n], map.getOrDefault(b[n] - a[n], 0) + 1);

        int max = 0;
        for (int val : map.values()) max = Math.max(max, val);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
