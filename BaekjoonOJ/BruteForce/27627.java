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

        String s = br.readLine();
        for (int i = s.length() - 1; i > 0; i--) {
            String a = s.substring(0, i), b = s.substring(i);
            if (isPalindrome(a) && isPalindrome(b)) {
                sb.append(a).append(' ').append(b);
                break;
            }
        }

        bw.write(sb.length() > 0 ? sb.toString() : "NO");
        bw.flush();
    }

    private static boolean isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

}
