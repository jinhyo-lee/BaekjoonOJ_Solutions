import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = read();
            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) min = Math.min(min, arr[i] - arr[i - 1]);
            sb.append(min).append('\n');
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
