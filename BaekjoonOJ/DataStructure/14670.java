import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        int n = read();
        while (n-- > 0) map.put(read(), read());

        int r = read();
        while (r-- > 0) {
            int[] arr = new int[read()];
            for (int i = 0; i < arr.length; i++) arr[i] = read();
            for (int i : arr) {
                if (!map.containsKey(i)) {
                    sb.setLength(0);
                    sb.append("YOU DIED");
                    break;
                } else sb.append(map.get(i)).append(' ');
            }
            bw.write(sb.append('\n').toString());
            sb.setLength(0);
        }

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
