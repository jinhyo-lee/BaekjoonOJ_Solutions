import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = {25, 10, 5, 1};
        int t = read();
        while (t-- > 0) {
            int c = read();
            for (int i = 0; i < 4; c %= arr[i++]) sb.append(c / arr[i]).append(' ');
            sb.setCharAt(sb.length() - 1, '\n');
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
