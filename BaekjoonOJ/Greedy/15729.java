import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();

        boolean[] arr = new boolean[n + 2];
        for (int i = 0; i < n; i++) arr[i] = read() == 1;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]) {
                arr[i + 1] = !arr[i + 1];
                arr[i + 2] = !arr[i + 2];
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
