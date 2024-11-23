import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) != -1) {
            if (isPerfect(n)) {
                sb.append(n).append(" = ");
                for (int i : list) sb.append(i).append(" + ");
                sb.replace(sb.length() - 3, sb.length(), "\n");
            } else sb.append(n).append(" is NOT perfect.\n");
            list.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPerfect(int n) {
        list.add(1);
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n % i != 0) continue;
            list.add(i);
            sum += i;
        }

        return sum == n;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
