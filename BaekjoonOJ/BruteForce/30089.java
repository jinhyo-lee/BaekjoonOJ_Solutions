import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            s = br.readLine();
            int i = 0;
            while (i < s.length() && !isSymmetric(i)) i++;

            sb.append(s);
            while (i-- > 0) sb.append(s.charAt(i));
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isSymmetric(int i) {
        int j = s.length();
        while (i < s.length()) if (s.charAt(i++) != s.charAt(--j)) return false;

        return true;
    }

}
