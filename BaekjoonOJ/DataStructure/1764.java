import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = read(), m = read();
        while (n-- > 0) set.add(readStr());

        List<String> list = new ArrayList<>();
        while (m-- > 0) if (set.contains(readStr())) list.add(sb.toString());
        Collections.sort(list);

        sb.setLength(0);
        sb.append(list.size()).append('\n');
        for (String s : list) sb.append(s).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

    private static String readStr() throws IOException {
        sb.setLength(0);
        int c;
        while ((c = System.in.read()) > 47) sb.append((char) c);

        return sb.toString();
    }

}
