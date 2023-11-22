import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[n];

        int sum = 0;
        while (n-- > 0) sum += arr[n] = read();

        int a = 0, b = 0, avg = sum / arr.length;
        for (int i : arr) {
            if (i > avg) a += i - avg - 1;
            else b += avg - i;
        }

        bw.write(String.valueOf(Math.max(a, b)));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
