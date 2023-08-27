import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        Set<Integer> set = new HashSet<>();

        while ((n = read()) != -1) {
            do set.add(n); while ((n = read()) != 0);

            int cnt = 0;
            for (int i : set) if (set.contains(i * 2)) cnt++;

            sb.append(cnt).append("\n");
            set.clear();
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
