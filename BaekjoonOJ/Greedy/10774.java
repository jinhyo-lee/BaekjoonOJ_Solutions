import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = convert(read());

        int cnt = 0;
        while (m-- > 0) {
            int c = convert(read()), i = read();

            if (arr[i] != 0 && arr[i] <= c) {
                arr[i] = 0;
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int convert(int i) {
        return i == 12 ? 1 : (i == 13 ? 2 : 3);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
