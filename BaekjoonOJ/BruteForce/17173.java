import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();
        boolean[] arr = new boolean[n + 1];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0, k = read(); j <= n; j++) {
                if (!arr[j] && j % k == 0) {
                    arr[j] = true;
                    sum += j;
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
