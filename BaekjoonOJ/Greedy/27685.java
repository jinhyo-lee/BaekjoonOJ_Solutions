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
        while (t-- > 0) {
            skip();
            int n = read(), i;
            while (n-- > 0) if (set.add(i = read())) sb.append(i).append(' ');
            sb.append('\n');
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

    private static void skip() throws IOException {
        int c;
        while ((c = System.in.read()) != '\n') if (c == -1) break;
    }

}
