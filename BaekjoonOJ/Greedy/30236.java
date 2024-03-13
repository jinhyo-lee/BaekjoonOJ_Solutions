import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = read();

            int res = 0;
            for (int i = 0, j = 1; i < n; i++, j++) res = arr[i] == j ? ++j : j;

            sb.append(res).append("\n");
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
