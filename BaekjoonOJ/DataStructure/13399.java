import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read();

        int[] arr = new int[m];
        for (int i = m - 1; i >= 0; i--) arr[i] = read();

        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.contains(i)) {
                sb.append(i).append("\n");
                set.add(i);
            }
        }

        for (int i = 1; i <= n; i++) if (!set.contains(i)) sb.append(i).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
