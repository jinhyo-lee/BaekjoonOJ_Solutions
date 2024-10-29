import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) != 0) {
            int sum = 0;
            for (int i = 1; i < n; i++) if (n % i == 0) sum += i;
            sb.append(n).append(sum < n ? " DEFICIENT\n" : sum == n ? " PERFECT\n" : " ABUNDANT\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c = System.in.read();
        while (c <= 32) c = System.in.read();
        int n = c & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
