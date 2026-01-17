import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0, n = 0;
        for (int i = 1; i < 6; i++) {
            int sum = read() + read() + read() + read();
            if (max >= sum) continue;
            max = sum;
            n = i;
        }

        bw.write(n + " " + max);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
