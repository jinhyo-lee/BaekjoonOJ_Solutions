import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = read();
        Arrays.sort(arr);

        int max = 0, res = -1;
        for (int i = 1; i < n; i++) {
            int diff = (arr[i] - arr[i - 1]) / 2;

            if (max < diff) {
                max = diff;
                res = (arr[i] + arr[i - 1]) / 2;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
