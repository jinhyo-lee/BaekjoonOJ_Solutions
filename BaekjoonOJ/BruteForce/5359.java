import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int[] arr = new int[read()];
            int m = read(), c = read();
            for (int i = 0; i < arr.length; i++) arr[i] = read();

            int cnt = 0;
            for (int i = m; i <= arr.length; i++) {
                int min = 1000, max = 0;
                for (int j = i - m; j < i; j++) {
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                }
                if (max - min <= c) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
