import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read(), c = read();
        int[] arr = new int[c];
        while (c-- > 0) arr[c] = read();

        Arrays.sort(arr);

        while (++c < arr.length && arr[c] <= t) t -= arr[c];

        bw.write(String.valueOf(c));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
