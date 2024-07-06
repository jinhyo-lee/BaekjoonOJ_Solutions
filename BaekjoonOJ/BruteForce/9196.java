import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 151; i++) for (int j = i + 1; j < 151; j++) list.add(new Pair(i, j));
        Collections.sort(list);

        int h;
        while ((h = read()) != 0) {
            Pair p = find(h, read());
            sb.append(p.h).append(" ").append(p.w).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Pair find(int h, int w) {
        Iterator<Pair> it = list.iterator();
        while (it.hasNext()) {
            Pair p = it.next();
            if (p.h == h && p.w == w) return it.next();
        }

        return new Pair(h, w);
    }

    private static class Pair implements Comparable<Pair> {
        int h, w, d;

        Pair(int h, int w) {
            this.h = h;
            this.w = w;
            this.d = h * h + w * w;
        }

        @Override
        public int compareTo(Pair o) {
            return this.d != o.d ? this.d - o.d : this.h - o.h;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
