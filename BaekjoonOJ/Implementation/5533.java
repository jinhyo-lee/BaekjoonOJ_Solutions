import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[][] mat = new int[n][3];
        for (int i = 0; i < n; i++) for (int j = 0; j < 3; j++) mat[i][j] = read();

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) map.put(mat[j][i], map.getOrDefault(mat[j][i], 0) + 1);
            for (int j = 0; j < n; j++) if (map.get(mat[j][i]) == 1) arr[j] += mat[j][i];
            map.clear();
        }

        for (int i : arr) sb.append(i).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
