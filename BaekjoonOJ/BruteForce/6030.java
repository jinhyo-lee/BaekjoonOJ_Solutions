import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int P = read(), Q = read(), max = Math.max(P, Q);
        List<Integer> p = new ArrayList<>(), q = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (P % i == 0) p.add(i);
            if (Q % i == 0) q.add(i);
        }

        for (int i : p) for (int j : q) sb.append(i).append(" ").append(j).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
