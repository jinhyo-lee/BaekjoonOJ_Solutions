import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), m = read(), cnt = 0;
        for (int i = 1; i <= n; i++) for (int j = 1; j <= m; j++) if (i + j == 10) cnt++;
        sb.append("There ").append(cnt == 1 ? "is " : "are ").append(cnt).append(" way").append(cnt == 1 ? "" : "s").append(" to get the sum 10.");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
