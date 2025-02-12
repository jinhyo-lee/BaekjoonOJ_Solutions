import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read(), l = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) l = Math.max(l, arr[i] = read());

        int max = 0;
        for (int i = 1; i <= l; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) if (arr[j] == i + j * k) cnt++;
            max = Math.max(max, cnt);
        }

        bw.write(String.valueOf(n - max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
