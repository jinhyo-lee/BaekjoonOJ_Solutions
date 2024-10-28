import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            sb.append("Case ").append(tc).append(":\n");
            int n = read();
            for (int i = 1; i < 7; i++)
                for (int j = i; j < 7; j++)
                    if (i + j == n) sb.append("(").append(i).append(",").append(j).append(")\n");
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
