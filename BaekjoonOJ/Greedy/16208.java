import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] arr = new long[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 1; i < arr.length; arr[i] += arr[i++ - 1]) sum += arr[i - 1] * arr[i];

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
