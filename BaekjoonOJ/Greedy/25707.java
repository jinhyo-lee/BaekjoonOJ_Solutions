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

        int sum = Math.abs(arr[0] - arr[arr.length - 1]);
        for (int i = 1; i < arr.length; i++) sum += Math.abs(arr[i - 1] - arr[i]);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
