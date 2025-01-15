import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(isPalindrome(br.readLine()));
        bw.flush();
    }

    private static char isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return '0';

        return '1';
    }

}
