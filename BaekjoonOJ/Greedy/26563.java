import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int m = read();
        while (m-- > 0) {
            int k = read(), s = 0, d = 0;
            String a = readStr(), b = readStr();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == b.charAt(i)) s++;
                else d++;
            }
            sb.append(Math.min(k, s) + Math.min(a.length() - k, d)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

    private static String readStr() throws IOException {
        sb.setLength(0);
        int c;
        while ((c = System.in.read()) > 47) sb.append((char) c);

        return sb.toString();
    }

}
