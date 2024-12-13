import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int n = read(), a;
        while (n-- > 0) map.put(a = read(), map.getOrDefault(a, 0) + read());

        sb.append(map.size()).append("\n");
        for (int k : map.keySet()) sb.append(k).append(" ").append(map.get(k)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
