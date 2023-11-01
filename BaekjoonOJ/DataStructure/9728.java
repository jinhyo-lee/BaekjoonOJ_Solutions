import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int n = read(), m = read();

            int[] arr = new int[n];
            while (n-- > 0) set.add(m - (arr[n] = read()));

            int cnt = 0;
            for (int i : arr) if (set.contains(i)) cnt++;

            sb.append("Case #").append(tc).append(": ").append(cnt / 2).append("\n");
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
