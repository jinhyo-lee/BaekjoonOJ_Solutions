import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) != 0) {
            int[] arr = new int[n];
            int m = read();
            for (int i = 0; i < n; i++) arr[i] = read();

            int max = 0;
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++) if (m >= arr[i] + arr[j]) max = Math.max(max, arr[i] + arr[j]);

            sb.append(max != 0 ? max : "NONE").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
