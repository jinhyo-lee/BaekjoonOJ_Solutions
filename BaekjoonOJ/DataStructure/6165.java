import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) arr[i] = new Pair(read(), read());

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
            }
        });

        Set<Double> set = new HashSet<>();
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) set.add(slope(arr[i], arr[j]));

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static double slope(Pair a, Pair b) {
        return (double) (b.x - a.x) / (b.y - a.y);
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
