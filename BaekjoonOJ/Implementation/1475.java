import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[10];

        do arr[n % 10]++; while ((n /= 10) > 0);
        arr[6] = (arr[6] + arr[9] + 1) / 2;

        int max = 0;
        for (int i = 0; i < 9; i++) max = Math.max(max, arr[i]);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
