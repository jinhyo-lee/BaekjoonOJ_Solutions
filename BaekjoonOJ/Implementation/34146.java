import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10001];
        int n = read(), m = read();
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) arr[read()]++;

        int cnt = 0;
        for (int i : arr) if ((i & 1) != 0) cnt++;

        bw.write((m & 1) != 0 ? cnt <= n ? "YES" : "NO" : cnt == 0 ? "YES" : "NO");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
