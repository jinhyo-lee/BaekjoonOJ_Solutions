import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(find(read() + 1, read())));
        bw.flush();
    }

    private static int find(int n, int k) {
        boolean[] arr = new boolean[n];

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i]) continue;

            for (int j = i; j < n; j += i) {
                if (arr[j]) continue;

                arr[j] = true;
                if (++cnt == k) return j;
            }
        }

        return 0;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
