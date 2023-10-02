import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr[i] = read();
        sum /= 2;

        for (int i = 1; i < n - 1; i += 2) sum -= arr[i];
        sb.append(sum).append("\n");

        for (int i = 0; i < n - 1; i++) sb.append(sum = arr[i] - sum).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
