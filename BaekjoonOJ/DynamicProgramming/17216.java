import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[n], dp = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = dp[i] = read();
            for (int j = 0; j < i; j++) if (arr[i] < arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
