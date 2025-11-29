import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1000001];
        int n = read(), a, b, c;
        while (n-- > 0) {
            if (arr[a = read()] || arr[b = read()] || arr[c = read()]) break;
            arr[a] = true;
            arr[b] = true;
            arr[c] = true;
        }

        bw.write(n == -1 ? "0" : "1");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
