import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 10; i++) graph.add(new ArrayList<>());

        int a = read(), b = read(), c = read();
        for (int i = 1; i < 11; i++) for (int j = 1; j < 11; j++) if (a * i + b * j == c) graph.get(i - 1).add(j);

        for (List<Integer> list : graph) {
            if (list.isEmpty()) sb.append('0');
            else for (int i : list) sb.append(i).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
