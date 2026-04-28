import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = read(), y = 1, x = 1, i = 0;
        int[][] dir = {{-1, -2}, {-2, -1}, {1, -2}, {-2, 1}, {2, -1}, {-1, 2}, {2, 1}, {1, 2}};
        Set<Integer> set = new HashSet<>();
        set.add(1);
        while (i < k) {
            boolean flag = false;
            for (int[] d : dir) {
                int ny = y + d[0], nx = x + d[1], p = (ny + nx - 1) * (ny + nx - 2) / 2 + nx;
                if (ny < 1 || nx < 1 || set.contains(p)) continue;
                set.add(p);
                y = ny;
                x = nx;
                flag = true;
                i++;
                break;
            }
            if (!flag) break;
        }

        bw.write(String.valueOf((y + x - 1) * (y + x - 2) / 2 + x));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
