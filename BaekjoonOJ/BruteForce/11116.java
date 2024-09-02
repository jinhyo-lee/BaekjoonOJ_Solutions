import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Integer> l = new HashSet<>(), r = new HashSet<>();
        int n = read();
        while (n-- > 0) {
            int m = read(), cnt = 0;
            for (int i = 0; i < m; i++) l.add(read());
            while (m-- > 0) {
                int i = read();
                if (l.contains(i - 1500) && l.contains(i - 1000) && r.contains(i - 500)) cnt++;
                r.add(i);
            }

            sb.append(cnt).append("\n");
            l.clear();
            r.clear();
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
