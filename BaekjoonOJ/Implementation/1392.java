import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), q = read(), sum = 0;
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= n; i++) sum += tmp[i] = read();

        int[] arr = new int[sum];
        for (int i = 0, j = 1; j <= n; j++) {
            int k = tmp[j];
            while (k-- > 0) arr[i++] = j;
        }

        while (q-- > 0) sb.append(arr[read()]).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
