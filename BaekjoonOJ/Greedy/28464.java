import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();

        int[] arr = new int[n];
        while (n-- > 0) arr[n] = read();

        Arrays.sort(arr);

        int a = 0, b = 0, s = 0, e = arr.length - 1, l = arr.length / 2;
        if (arr.length % 2 != 0) b += arr[l];

        while (s < l) {
            a += arr[s++];
            b += arr[e--];
        }

        bw.write(a + " " + b);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
