import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static List<List<Integer>> lists = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), i;
        while (n-- > 0) {
            List<Integer> list = new ArrayList<>();
            while ((i = read()) != -1) list.add(i);

            lists.add(list);
        }

        int k = 0;
        while (!isDistinct(k++)) set.clear();

        bw.write(String.valueOf(k));
        bw.flush();
    }

    private static boolean isDistinct(int k) {
        for (List<Integer> list : lists) {
            if (k < list.size()) {
                if (set.contains(list.get(k))) return false;
                set.add(list.get(k));
            }
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
