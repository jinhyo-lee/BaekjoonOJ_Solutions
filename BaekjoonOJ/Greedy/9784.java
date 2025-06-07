import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int[] arr = new int[read()];
            int p = read(), q = read();

            for (int i = 0; i < arr.length; i++) arr[i] = read();
            Arrays.sort(arr);

            int cnt = 0;
            for (int i : arr) if ((q -= i) >= 0 && p-- > 0) cnt++;

            sb.append("Case ").append(tc).append(": ").append(cnt).append('\n');
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
