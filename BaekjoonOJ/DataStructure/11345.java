import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> A = new HashMap<>(), B = new HashMap<>();
        int t = read();
        while (t-- > 0) {
            skip();
            int n = read();
            for (int i = 0, k; i < n; i++) A.put(k = read(), A.getOrDefault(k, 0) + 1);
            for (int i = 0, k; i < n; i++) B.put(k = read(), B.getOrDefault(k, 0) + 1);

            int[] a = new int[A.size()], b = new int[B.size()];
            n = 0;
            for (int v : A.values()) a[n++] = v;
            n = 0;
            for (int v : B.values()) b[n++] = v;

            Arrays.sort(a);
            Arrays.sort(b);

            String s = "what a lovely party\n";
            if (a.length != b.length) s = "you've messed up, Cornell\n";
            else {
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i]) {
                        s = "you've messed up, Cornell\n";
                        break;
                    }
                }
            }

            sb.append(s);
            A.clear();
            B.clear();
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
