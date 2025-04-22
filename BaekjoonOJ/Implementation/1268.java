import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        mat = new int[n][5];
        for (int i = 0; i < n; i++) for (int j = 0; j < 5; j++) mat[i][j] = read();

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[5];
            System.arraycopy(mat[i], 0, arr, 0, 5);

            int cnt = 0;
            for (int j = 0; j < n; j++) if (j != i && search(arr, j)) cnt++;
            if (max < cnt) {
                max = cnt;
                res = i;
            }
        }

        bw.write(String.valueOf(res + 1));
        bw.flush();
    }

    private static boolean search(int[] arr, int j) {
        for (int k = 0; k < 5; k++) if (arr[k] == mat[j][k]) return true;
        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
