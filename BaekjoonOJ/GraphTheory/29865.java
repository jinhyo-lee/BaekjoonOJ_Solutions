import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int y = s.charAt(0) - 96, x = s.charAt(1) - 48;
        int[][] dir = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Set<String> set = new HashSet<>();

        for (int[] a : dir) {
            int y1 = y + a[0], x1 = x + a[1];
            if (y1 < 1 || y1 > 8 || x1 < 1 || x1 > 8) continue;

            for (int[] b : dir) {
                int y2 = y1 + b[0], x2 = x1 + b[1];
                if (y2 < 1 || y2 > 8 || x2 < 1 || x2 > 8) continue;

                set.add((char) (y2 + 96) + Integer.toString(x2));
            }
        }

        for (String c : set) sb.append(c).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
