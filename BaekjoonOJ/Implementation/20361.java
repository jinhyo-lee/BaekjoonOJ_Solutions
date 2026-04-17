import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[read() + 1];
        arr[read()] = true;
        for (int i = read(); i > 0; i--) {
            int a = read(), b = read();
            boolean f = arr[a];
            arr[a] = arr[b];
            arr[b] = f;
        }

        int i = 0;
        for (boolean f : arr) {
            if (f) break;
            i++;
        }

        bw.write(String.valueOf(i));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
