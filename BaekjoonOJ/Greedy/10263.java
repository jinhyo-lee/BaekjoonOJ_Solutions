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

        int min = n--;
        for (int i = n; i >= 0; i--) min = Math.min(min, arr[i] + n - i);

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
