import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read();
        List<Integer> a = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) a.add(read() - 1, i);
        a.subList(m, n).clear();

        List<Integer> b = new ArrayList<>(m);
        while (m-- > 0) {
            int i = read() - 1;
            if (i >= 3) continue;
            b.add(i, a.get(m));
            if (b.size() > 3) b.remove(3);
        }

        for (int i = 0; i < 3; i++) sb.append(b.get(i)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
