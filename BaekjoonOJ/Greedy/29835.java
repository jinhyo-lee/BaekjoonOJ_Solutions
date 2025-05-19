import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(replaceToPalindrome(read() / 2, new StringBuilder(readStr())));
        bw.flush();
    }

    private static String replaceToPalindrome(int n, StringBuilder s) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == s.charAt(s.length() - i - 1)) continue;

            if (s.charAt(i) < s.charAt(s.length() - i - 1)) s.setCharAt(s.length() - i - 1, s.charAt(i));
            else s.setCharAt(i, s.charAt(s.length() - i - 1));
            cnt++;
        }

        return cnt + "\n" + s;
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
