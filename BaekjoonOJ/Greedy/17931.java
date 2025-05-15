import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        int n = read(), i;
        list.add(read());
        while (n-- > 1) if ((i = read()) > list.get(list.size() - 1)) list.add(i);

        sb.append(list.size()).append('\n');
        for (int j : list) sb.append(j).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
