import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[] arr = new int[n], dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = read();
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (arr[i] > arr[j]) dp[i] = (dp[i] + dp[j]) % 998244353;
        }

        for (int i : dp) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
