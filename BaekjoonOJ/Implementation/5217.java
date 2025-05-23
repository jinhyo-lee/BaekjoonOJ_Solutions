import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read();
            sb.append("Pairs for ").append(n).append(":");
            for (int i = 1; i <= n / 2; i++)
                if (n - i != i) sb.append(" ").append(i).append(" ").append(n - i).append(",");

            if (sb.charAt(sb.length() - 1) != ':') sb.setCharAt(sb.length() - 1, '\n');
            else sb.append("\n");
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
