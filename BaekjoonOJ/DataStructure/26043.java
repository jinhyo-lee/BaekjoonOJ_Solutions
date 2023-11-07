import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Pair> q = new ArrayDeque<>();
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>();

        int n = read();
        while (n-- > 0) {
            if (read() == 1) q.offer(new Pair(read(), read()));
            else if (!q.isEmpty()) {
                Pair pair = q.poll();
                if (read() == pair.b) A.add(pair.a);
                else B.add(pair.a);
            }
        }

        while (!q.isEmpty()) C.add(q.poll().a);

        print(sb, A);
        print(sb, B);
        print(sb, C);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void print(StringBuilder sb, List<Integer> list) {
        if (list.isEmpty()) sb.append("None\n");
        else {
            Collections.sort(list);
            for (int i : list) sb.append(i).append(" ");
            sb.append("\n");
        }
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
