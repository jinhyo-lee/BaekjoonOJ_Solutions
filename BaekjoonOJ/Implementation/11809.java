import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine(), m = br.readLine();
        int l = Math.abs(n.length() - m.length());
        if (n.length() < m.length()) compare(zero(l) + n, m, sb);
        else compare(n, zero(l) + m, sb);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void compare(String n, String m, StringBuilder sb) {
        StringBuilder A = new StringBuilder(), B = new StringBuilder();
        int l = n.length();
        for (int i = 0; i < l; i++) {
            char a = n.charAt(i), b = m.charAt(i);
            if (a <= b) B.append(b);
            if (a >= b) A.append(a);
        }

        sb.append(A.length() > 0 ? Integer.parseInt(A.toString()) : "YODA").append('\n').append(B.length() > 0 ? Integer.parseInt(B.toString()) : "YODA");
    }

    private static String zero(int l) {
        StringBuilder sb = new StringBuilder();
        while (l-- > 0) sb.append('0');

        return sb.toString();
    }

}
