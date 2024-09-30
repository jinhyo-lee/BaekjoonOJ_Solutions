import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {0, 1, 2, 3};
        int m = read();
        while (m-- > 0) {
            int x = read(), y = read(), z = arr[x];
            arr[x] = arr[y];
            arr[y] = z;
        }

        bw.write(String.valueOf(arr[1] == 1 ? 1 : arr[2] == 1 ? 2 : 3));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
