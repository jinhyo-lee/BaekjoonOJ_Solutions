import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        Map<Integer, Boolean> map = new HashMap<>();
        int t = read(), cnt = 0;
        for (int i : arr) {
            int q = i / t;
            if (!map.getOrDefault(q, false)) cnt++;
            map.put(q, true);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
