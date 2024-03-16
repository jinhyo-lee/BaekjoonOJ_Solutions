import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        Arrays.sort(arr);

        int e = 0, o = 0;
        while (n-- > 0) {
            if ((n & 1) == 0) e += arr[n];
            else o += arr[n];
        }

        bw.write(e > o ? e + " " + o : o + " " + e);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
