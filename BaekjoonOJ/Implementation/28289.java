import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[4];
        int p = read();
        while (p-- > 0) {
            int g = read(), c = read();
            arr[g > 1 ? c == 1 || c == 2 ? 0 : c == 3 ? 1 : 2 : 3]++;
            read();
        }

        for (int i : arr) sb.append(i).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
