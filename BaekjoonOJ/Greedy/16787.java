import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), cnt = 0;
        String s = readStr();
        while (n-- > 1) {
            if (s.charAt(n) != s.charAt(n - 1)) {
                cnt++;
                n--;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static String readStr() throws IOException {
        sb.setLength(0);
        int c;
        while ((c = System.in.read()) > 47) sb.append((char) c);

        return sb.toString();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
