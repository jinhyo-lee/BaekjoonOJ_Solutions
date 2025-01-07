import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int d;
        while ((d = read()) != 0) {
            int e = read();
            double min = 100;
            for (int i = 0; i < d; i++)
                min = Math.min(min, Math.abs(Math.sqrt(Math.pow(i, 2) + Math.pow(d - i, 2)) - e));
            sb.append(min).append("\n");
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
