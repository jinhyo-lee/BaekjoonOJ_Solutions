import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = read(), n = read(), t = k;

        int[] arr = new int[n];
        int[][] mat = new int[n][n];

        while (t-- > 0) {
            for (int i = 0; i < n; i++) arr[i] = read() - 1;

            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++) mat[arr[i]][arr[j]]++;
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) if (mat[i][j] == k) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
