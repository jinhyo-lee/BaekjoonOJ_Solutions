import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0, min = 100;
        for (int i = 0; i < 7; i++) {
            int n = read();
            if ((n & 1) == 0) continue;
            sum += n;
            min = Math.min(min, n);
        }

        bw.write(sum == 0 ? "-1" : sum + "\n" + min);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
