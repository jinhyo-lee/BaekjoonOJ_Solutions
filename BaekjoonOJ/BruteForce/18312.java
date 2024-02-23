import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read(), cnt = 0;
        for (int h = 0; h <= n; h++)
            for (int m = 0; m < 60; m++)
                for (int s = 0; s < 60; s++)
                    if (h % 10 == k || h / 10 == k || m % 10 == k || m / 10 == k || s % 10 == k || s / 10 == k) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
