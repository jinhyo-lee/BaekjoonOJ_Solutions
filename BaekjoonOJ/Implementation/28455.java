import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = Math.max(n - 42, 0), sum = 0, cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();
        Arrays.sort(arr);

        while (n-- > m) {
            sum += arr[n];
            cnt += measure(arr[n]);
        }

        bw.write(sum + " " + cnt);
        bw.flush();
    }

    private static int measure(int i) {
        return i < 60 ? 0 : i < 100 ? 1 : i < 140 ? 2 : i < 200 ? 3 : i < 250 ? 4 : 5;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
