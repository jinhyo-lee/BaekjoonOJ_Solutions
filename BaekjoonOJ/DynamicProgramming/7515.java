import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] cache = new int[41];
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < 41; i++) cache[i] = cache[i - 1] + cache[i - 2];

        int t = read();
        for (int i = 1; i <= t; i++)
            sb.append("Scenario ").append(i).append(":\n").append(cache[read()]).append("\n\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
