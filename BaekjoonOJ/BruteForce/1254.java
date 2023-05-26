import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int len = s.length();
        for (int i = 0; i < s.length(); i++, len++) {
            if (isPalindrome(s.substring(i)))
                break;
        }

        bw.write(String.valueOf(len));
        bw.flush();
    }

    private static boolean isPalindrome(String s) {
        int half = s.length() / 2;

        for (int i = 0; i < half; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }

}
