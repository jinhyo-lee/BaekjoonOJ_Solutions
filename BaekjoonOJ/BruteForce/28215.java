import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mat = new int[read()][2];
        int k = read();
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = read();
            mat[i][1] = read();
        }

        loop(k - 1, 0, new int[k]);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static void loop(int k, int i, int[] arr) {
        if (k == -1) {
            min = Math.min(min, calc(arr));
            return;
        }

        for (int j = i; j < mat.length - k; j++) {
            arr[k] = j;
            loop(k - 1, j + 1, arr);
        }
    }

    private static int calc(int[] tgt) {
        int max = 0;
        for (int[] src : mat) {
            int min = Integer.MAX_VALUE;
            for (int j : tgt) min = Math.min(min, Math.abs(src[0] - mat[j][0]) + Math.abs(src[1] - mat[j][1]));
            max = Math.max(max, min);
        }

        return max;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
