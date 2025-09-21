import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = {150, 30, 15, 5, 1};
        int n = read();
        for (int i = 0; i < arr.length; i++) {
            int m = arr[i];
            arr[i] = n / m;
            n %= m;
        }

        for (int i = arr.length - 1; i >= 0; i--) sb.append(arr[i]).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
